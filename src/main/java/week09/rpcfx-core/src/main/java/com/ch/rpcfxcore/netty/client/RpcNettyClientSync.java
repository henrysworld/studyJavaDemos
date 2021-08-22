package com.ch.rpcfxcore.netty.client;

import com.alibaba.fastjson.JSON;
import com.ch.rpcfxcore.api.RpcRequest;
import com.ch.rpcfxcore.api.RpcResponse;
import com.ch.rpcfxcore.netty.common.RpcProtocol;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:51
 * @Version: 1.0
 */
@Slf4j
public class RpcNettyClientSync {
    private enum EnumSingleton{
        INSTANCE;
        private RpcNettyClientSync instance;

        EnumSingleton(){
            instance = new RpcNettyClientSync();
        }
        public RpcNettyClientSync getSingleton(){
            return instance;
        }
    }

    public static RpcNettyClientSync getInstance(){
        return EnumSingleton.INSTANCE.getSingleton();
    }

    /**
     * 使用Map来保存用过的Channel，看下次相同的后台服务是否能够重用，起一个类似缓存的作用
     */

    private ConcurrentHashMap<String, Channel> channelPool = new ConcurrentHashMap<>();
    private EventLoopGroup clientGroup = new NioEventLoopGroup(new ThreadFactoryBuilder().setNameFormat("client work-%d").build());

    private RpcNettyClientSync(){

    }

    /**
     * 调用channel发送请求，从handler中获取响应结果
     * @return 响应
     * @throws InterruptedException exception
     */
    public RpcResponse getResponse(RpcRequest rpcRequest, String url) throws URISyntaxException, InterruptedException {
        RpcProtocol rpcProtocol = convertNettyRequest(rpcRequest);

        URI uri = new URI(url);
        String cacheKey = uri.getHost() + ":" + uri.getPort();

        //查看缓存池中是否有可用的channel
        if (channelPool.containsKey(cacheKey)){
            Channel channel = channelPool.get(cacheKey);
            if (!channel.isActive() || !channel.isWritable() || !channel.isOpen()){
                log.debug("Channel can't reuse");

            } else {
                RpcClientSyncHandler handler = new RpcClientSyncHandler();
                handler.setLatch(new CountDownLatch(1));
                channel.pipeline().replace("clientHandler", "chientHandler", handler);
                try {
                    channel.writeAndFlush(rpcProtocol).sync();
                    return handler.getResponse();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    channel.close();
                    channelPool.remove(cacheKey);
                }

                log.debug("Handler is busy, please user new channel");
            }
        }

        // 没有或者不可用则新建
        // 并将最终的handler添加到pipeline中，拿到结果后返回

        RpcClientSyncHandler handler = new RpcClientSyncHandler();
        handler.setLatch(new CountDownLatch(1));

        Channel channel = createChannel(uri.getHost(), uri.getPort());
        channel.pipeline().replace("clientHandler", "clientHandler", handler);
        channelPool.put(cacheKey, channel);

        channel.writeAndFlush(rpcProtocol).sync();
        return handler.getResponse();
    }

    private Channel createChannel(String address, int port) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(clientGroup)
                .option(ChannelOption.SO_REUSEADDR, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.AUTO_CLOSE, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .channel(NioSocketChannel.class)
                .handler(new RpcClientInitializer());
        return bootstrap.connect(address, port).sync().channel();
    }

    private RpcProtocol convertNettyRequest(RpcRequest rpcRequest) {
        RpcProtocol rpcProtocol = new RpcProtocol();
        String requestJson = JSON.toJSONString(rpcRequest);
        rpcProtocol.setLen(requestJson.getBytes(CharsetUtil.UTF_8).length);
        rpcProtocol.setContent(requestJson.getBytes(CharsetUtil.UTF_8));
        return rpcProtocol;
    }

    public void destory(){
        clientGroup.shutdownGracefully();
    }

}
