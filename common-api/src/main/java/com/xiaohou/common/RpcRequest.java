package com.xiaohou.common;

import java.io.Serializable;

/**
 * 通过此类确定调用哪个类，哪个方法
 */
public class RpcRequest implements Serializable{

    private String className;//类名
    private String methodName;//方法名
    private Object[] parmsName;//参数
    private Class[] parmsType;//参数类型
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParmsName() {
        return parmsName;
    }

    public void setParmsName(Object[] parmsName) {
        this.parmsName = parmsName;
    }

    public Class[] getParmsType() {
        return parmsType;
    }

    public void setParmsType(Class[] parmsType) {
        this.parmsType = parmsType;
    }
}
