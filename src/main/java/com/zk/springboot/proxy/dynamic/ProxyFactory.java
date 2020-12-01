package com.zk.springboot.proxy.dynamic;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * 动态代理
 * 1.根据传入的对象，目标对象
 * 2.利用返回机制，返回一个代理对象
 * 3.然后通过代理对象，调用目标对象方法
 */
public class ProxyFactory {

    // 维护一个object
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成一个代理对象
     * 参数解释
     * 1. 指定当前目标对象使用的类加载器，获取加载器的方法固定
     * 2.目标对象实现的接口类型，使用泛型方法确认类型
     * 3.事件处理，执行目标对象的方法时，会触发事件处理器方法，
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("JDK 代理 开始 ~~~~");
                Object invoke = method.invoke(target, args);
                System.out.println("JDK 代理 结束 ~~~~");
                return invoke;
            }
        });
    }
}
