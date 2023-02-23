package com.itwen.test;

import com.itwen.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 21:20
 * 文件描述：
 */
public class AutowireByXmlText {
    @Test
    public void testAutoWire(){
        ApplicationContext ioc =  new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
