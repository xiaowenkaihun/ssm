package com.itwen.test;

import com.itwen.factory.UserFactoryBean;
import com.itwen.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 20:43
 * 文件描述：
 */
public class FactoryBeanTest {
    @Test
    public void testFactoryBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);

    }
}
