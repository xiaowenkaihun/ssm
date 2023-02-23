package com.itwen.test;

import com.itwen.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.rmi.CORBA.Stub;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 19:56
 * 文件描述：
 */
public class TestScope {

    @Test
    public void testScope(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student stu1 = ioc.getBean(Student.class);
        Student stu2 = ioc.getBean(Student.class);
        System.out.println(stu2==stu1);
    }
}
