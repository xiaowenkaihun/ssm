package com.itwen.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 20:25
 * 文件描述：
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor》》后置处理器 postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //

        System.out.println("MyBeanPostProcessor》》后置处理器 postProcessAfterInitialization");
        return bean;
    }
}
