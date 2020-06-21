package com.xiaohou.client;

import java.lang.reflect.Proxy;

/**
 * 客户端动态代理类
 */
public class RpcProxyClient {
    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class<?>[]{interfaceCls},new RpcProxyHandler(host,port));
    }
}
