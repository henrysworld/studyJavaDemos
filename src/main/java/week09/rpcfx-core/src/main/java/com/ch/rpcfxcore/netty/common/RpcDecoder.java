package com.ch.rpcfxcore.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:56
 * @Version: 1.0
 */
@Slf4j
public class RpcDecoder extends ByteToMessageDecoder {
    private int length = 0;
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        log.info("Netty decode run");
        if (byteBuf.readableBytes() >= 4){
            if (length == 0){
                length = byteBuf.readInt();
            }
            if (byteBuf.readableBytes() < length){
                log.info("Readable data is less, wait");
                return;
            }

            byte[] content = new byte[length];
            if (byteBuf.readableBytes() >= length){
                byteBuf.readBytes(content);
                RpcProtocol rpcProtocol = new RpcProtocol();
                rpcProtocol.setLen(length);
                rpcProtocol.setContent(content);
                list.add(rpcProtocol);
            }
            length = 0;
        }
    }
}
