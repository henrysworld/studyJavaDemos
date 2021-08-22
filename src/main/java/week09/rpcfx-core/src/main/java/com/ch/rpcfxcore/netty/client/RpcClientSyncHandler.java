package com.ch.rpcfxcore.netty.client;

import com.alibaba.fastjson.JSON;
import com.ch.rpcfxcore.api.RpcResponse;
import com.ch.rpcfxcore.netty.common.RpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:51
 * @Version: 1.0
 */
@Slf4j
public class RpcClientSyncHandler extends SimpleChannelInboundHandler<RpcProtocol> {
    private CountDownLatch latch;
    private RpcResponse response;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcProtocol msg) throws Exception {
        log.info("Netty client receive message:");
        log.info("Message length: " + msg.getLen());
        log.info("Message content: " + new String(msg.getContent(), CharsetUtil.UTF_8));

        // 将 RpcResponse字符串 反序列化成 RpcResponse对象
        RpcResponse rpcResponse = JSON.parseObject(new String(msg.getContent(), CharsetUtil.UTF_8), RpcResponse.class);
        log.info("Netty client serializer : " + rpcResponse.toString());

        response = rpcResponse;
        latch.countDown();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    void setLatch(CountDownLatch latch){
        this.latch = latch;
    }

    RpcResponse getResponse() throws InterruptedException {
        latch.await();
        return response;
    }
}
