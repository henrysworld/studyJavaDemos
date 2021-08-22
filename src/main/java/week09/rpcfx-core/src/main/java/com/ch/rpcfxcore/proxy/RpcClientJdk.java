package com.ch.rpcfxcore.proxy;

import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Proxy;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 0:09
 * @Version: 1.0
 */
public class RpcClientJdk extends RpcProxy implements RpcClient{
    @Override
    public <T> T create(Class<T> serviceClass, String url) {
        //查询是否之前生成过，存储的直接返回
        if (!isExit(serviceClass.getName())){
            add(serviceClass.getName(), newProxy(serviceClass, url));
        }
        return (T) getProxy(serviceClass.getName());
    }

    private <T> T newProxy(Class<T> serviceClass, String url) {
        ClassLoader loader = RpcClientJdk.class.getClassLoader();
        Class[] classes = new Class[]{serviceClass};
        return (T) Proxy.newProxyInstance(loader, classes, new RpcInvocationHandler(serviceClass, url));    }
}
