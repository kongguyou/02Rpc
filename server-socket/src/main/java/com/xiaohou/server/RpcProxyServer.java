package com.xiaohou.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 动态代理类
 */
public class RpcProxyServer{
    public static final ExecutorService ex=Executors.newCachedThreadPool();
    public void publishService(Object service,int port){
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            while(true){
                Socket socket = serverSocket.accept();
                ex.execute(new Thread(new ProcessHandler(socket,service)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
