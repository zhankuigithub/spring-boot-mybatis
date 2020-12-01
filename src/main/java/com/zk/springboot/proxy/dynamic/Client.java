package com.zk.springboot.proxy.dynamic;

public class Client {

    public static void main(String[] args) {

         // 创建目标对象
        ITeachDao target = new TeachDao();
        // 创建代理对象
        ProxyFactory factory = new ProxyFactory(target);

        ITeachDao instance = (ITeachDao)factory.getProxyInstance();

        instance.teach();

    }

}
