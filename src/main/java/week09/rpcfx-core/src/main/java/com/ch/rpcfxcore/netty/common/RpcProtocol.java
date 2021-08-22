package com.ch.rpcfxcore.netty.common;

import lombok.Data;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:57
 * @Version: 1.0
 */
@Data
public class RpcProtocol {
    //数据大小
    private int len;

    //数据内容
    private byte[] content;
}
