package com.ch.rpcfxcore.api;

import lombok.Data;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:44
 * @Version: 1.0
 */
@Data
public class RpcRequest {

    //接口类名
    private String serviceClass;

    //方法名
    private String method;

    //参数
    private Object[] argv;

}
