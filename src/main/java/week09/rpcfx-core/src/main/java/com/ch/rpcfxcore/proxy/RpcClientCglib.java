package com.ch.rpcfxcore.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 0:08
 * @Version: 1.0
 */
@Slf4j
public class RpcClientCglib extends RpcProxy implements RpcClient{
    @Override
    public <T> T create(Class<T> serviceClass, String url) {
        if (!isExit(serviceClass.getName())){
            add(serviceClass.getName(), newProxy(serviceClass, url));
        }
        return (T) getProxy(serviceClass.getName());
    }

    private <T> T newProxy(Class<T> serviceClass, String url) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new RpcInvocationHandler(serviceClass, url));
        enhancer.setSuperclass(serviceClass);
        log.info("client cglib proxy instance create and return");
        return (T) enhancer.create();
    }
}
