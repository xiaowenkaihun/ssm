package com.itwen.test;

import com.itwen.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 20:17
 * 文件描述：
 */
public class TestBeanLifeCycle {
    @Test
    /**
     * 因为bean是单例
     * 所以在床架ioc容器的时候就已经创建好了
     * 如果bean是多例
     * ioc就不会自己创建对象了
     */
    public void testBeanLifeCycle(){
        // ConfigurableApplicationContexts是ApplicationContext的子接口，扩展了关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
