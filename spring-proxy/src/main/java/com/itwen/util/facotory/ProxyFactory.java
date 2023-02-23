package com.itwen.util.facotory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 22:00
 * 文件描述：
 */

/**
 * 动态代理：
 * jdk动态代理：要求必须要接口，最终生成的代理类和目标实现相同的接口在com.sun.proxy包下，类名叫$proxy1
 * cglib动态代理：最终生成的代理类最终会继承目标类，并且和目标类在相同的包下
 */
@SuppressWarnings("all")
@Component
public class ProxyFactory {


    private Object target;

    public ProxyFactory() {
    }

    public ProxyFactory(Object target) {
        this.target = target;
    }


    public Object getProxy(){
        /**
         * ClassLoader loader：类加载器，动态生成一个代理类
         * Class<?>[] interfaces：获取目标对象实现的所有接口的class数组
         * InvocationHandler h：设置代理类里面的方法该如何重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = this.target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("日志，方法"+method.getName()+"参数"+ Arrays.toString(args));
                    // proxy表示代理对象
                    // method表示要执行的方法
                    // args表示执行方法所需要的参数列表
                    result = method.invoke(target, args);
                    System.out.println("日志，方法"+method.getName()+"结果"+result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志，方法"+method.getName()+"异常"+e);
                } finally {
                    System.out.println("日志，方法"+method.getName()+"方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, h);
    };
}
