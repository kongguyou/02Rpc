package com.xiaohou.server;

import com.xiaohou.service.SayHelloService;

public class ServerApp {
    public static void main(String[] args) {
        //将服务推送出去
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        SayHelloService sayHelloService = new SayHelloServiceImpl();
        rpcProxyServer.publishService(sayHelloService,8088);
    }
}
