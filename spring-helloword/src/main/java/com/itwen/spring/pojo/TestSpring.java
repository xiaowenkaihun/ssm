package com.itwen.spring.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/16 10:04
 * 文件描述：
 */
public class TestSpring {
    @Test
    public void testHelloWord(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWord helloword = (HelloWord) ioc.getBean("helloword");
        helloword.sayHello();

    }
}
