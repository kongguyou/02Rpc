package com.xiaohou.server;

import com.xiaohou.service.SayHelloService;

public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello() {
        return "hello world";
    }

    @Override
    public String sayHelloByName(String name) {
        return "hello "+name;
    }

}
