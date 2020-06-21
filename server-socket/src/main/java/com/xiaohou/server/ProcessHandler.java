package com.xiaohou.server;

import com.xiaohou.common.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 动态代理的处理程序
 */
public class ProcessHandler implements Runnable{
    private Socket socket;
    private Object service;
    public ProcessHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }
    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(rpcRequest);
            //将执行结果返回给客户端
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object invoke(RpcRequest rpcRequest){

        try {
            //通过反射确定调用的哪个类
            String className = rpcRequest.getClassName();
            Class<?> clazz = Class.forName(className);
            //根据方法名和传参类型确定调用哪个方法
            Method method = clazz.getMethod(rpcRequest.getMethodName(), rpcRequest.getParmsType());
            //传入实例和参数调用该方法
            return method.invoke(service,rpcRequest.getParmsName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //通过反射判断调用的哪个方法

        return null;

    }
}



























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































