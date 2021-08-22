package com.ch.rpcfxcore.api;

import lombok.Data;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/21 23:44
 * @Version: 1.0
 */
@Data
public class RpcResponse {
    //相应结果
    private Object result;

    //函数是否执行成功
    private Boolean status;

    //执行失败的异常
    private Exception exception;
}
