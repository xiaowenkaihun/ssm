package com.itwen.test;

import com.itwen.pojo.Clazz;
import com.itwen.pojo.Person;
import com.itwen.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/16 10:48
 * 文件描述：
 */
public class TestSpring {
    /**
     * 获取bean的三种方式
     * 1， id
     * 2， bean的类型
     */
    @Test
    public void testOne(){
        ApplicationContext ioc =  new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ioc.getBean("studentOne");
        System.out.println(student);
    }

    @Test
    /**
     * 根据类型获得bean的时候，要求IOC当中有且只有一个匹配的bean
     * 若没有一个类型匹配的bean
     * 用的最多的就是第二种
     * 因为在配置的时候一般一个类型只有一个
     */
    public void testTwo(){
        ApplicationContext ioc =  new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean(Student.class);
        System.out.println(student);
    }

    @Test
    public void testThree() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }
    @Test
    public void testFour() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person student = ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }


    @Test
    public void testFive() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);
    }

    @Test
    public void testSix() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person student = ioc.getBean("studentThree", Student.class);
        System.out.println(student);
    }

    @Test
    public void testSeven() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentFour", Student.class);
        System.out.println(student);
    }

    @Test
    public void testEight() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentFive", Student.class);
        System.out.println(student);
        Student student2 = ioc.getBean("studentSix", Student.class);
        System.out.println(student2 );

        Clazz clazz = ioc.getBean("clazzOne",Clazz.class);
        System.out.println(clazz);

    }

    @Test
    public void testNine() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentSeven", Student.class);
        System.out.println(student);
    }

    @Test
    public void testOneOne() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazzTwo = ioc.getBean("clazzTwo", Clazz.class);
        System.out.println(clazzTwo);
    }

    @Test
    public void testOneTwo() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazzThree = ioc.getBean("clazzThree", Clazz.class);
        System.out.println(clazzThree);
    }

    @Test
    public void testOneThree() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentOneOne", Student.class);
        System.out.println(student);
    }


}
