package com.ch.rpcfxcore.proxy;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 0:08
 * @Version: 1.0
 */
public interface RpcClient {

    <T> T create(final Class<T> serviceClass, final String url);
}
