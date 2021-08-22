package com.ch.rpcfxcore.netty.client;

import com.ch.rpcfxcore.netty.server.RpcServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:50
 * @Version: 1.0
 */
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("Message Encoder", new RpcClientSyncHandler());

    }
}
