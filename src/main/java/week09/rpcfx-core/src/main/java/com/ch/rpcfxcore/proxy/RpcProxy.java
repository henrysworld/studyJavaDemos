package com.ch.rpcfxcore.proxy;

import io.netty.bootstrap.Bootstrap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/22 0:09
 * @Version: 1.0
 */
public class RpcProxy {

    private ConcurrentHashMap<String, Object> proxyCache = new ConcurrentHashMap<>();

    Object getProxy(String className){
        return proxyCache.get(className);
    }

    Boolean isExit(String className){
        return proxyCache.containsKey(className);
    }

    void add(String className, Object proxy){
        proxyCache.put(className, proxy);
    }
}
