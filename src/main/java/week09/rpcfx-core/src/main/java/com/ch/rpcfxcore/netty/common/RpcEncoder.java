package com.ch.rpcfxcore.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:56
 * @Version: 1.0
 */
@Slf4j
public class RpcEncoder extends MessageToByteEncoder<RpcProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RpcProtocol rpcProtocol, ByteBuf byteBuf) throws Exception {
        log.info("Netty rpc encode run");
        byteBuf.writeInt(rpcProtocol.getLen());
        byteBuf.writeBytes(rpcProtocol.getContent());
    }
}
