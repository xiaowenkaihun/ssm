package com.itwen.Factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 22:27
 * 文件描述：
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object proxy) {
        this.target = proxy;
    }

    public Object getProxy(){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(proxy, args);
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    };
}
