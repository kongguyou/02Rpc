package com.xiaohou.client;

import com.xiaohou.service.SayHelloService;

public class ClientApp {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        //因为不在一个项目中，不能直接new，只能通过远程通信创建一个实例
        // SayHelloService sayHelloService = new SayHelloServiceImpl();//编译报错
        SayHelloService sayHelloService = rpcProxyClient.clientProxy(SayHelloService.class, "localhost", 8088);
        System.out.println(sayHelloService.sayHello());
        System.out.println(sayHelloService.sayHelloByName("猿小猴"));
    }
}
