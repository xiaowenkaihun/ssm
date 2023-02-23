package com.itwen.test;

import com.itwen.contoller.UserController;
import com.itwen.dao.UserDao;
import com.itwen.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 10:49
 * 文件描述：
 */
public class IOCAnnotationTest {

    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     *
     * 类名首字母小写就是bean的id。例如：UserController类对应的bean的id就是userController。 自定义bean的id
     * 可通过标识组件的注解的value属性设置自定义的bean的id
     * @Service("userService")//默认为userServiceImpl public class UserServiceImpl implements
     * UserService {}
     */
    @Test
    public void iocAnnotationTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ioc.getBean("controller",UserController.class);

        /*System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl", UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao);*/

        userController.saverUser();
    }

    @Test
    public void testIOC(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ioc.getBean("controller",UserController.class);
    }
}
