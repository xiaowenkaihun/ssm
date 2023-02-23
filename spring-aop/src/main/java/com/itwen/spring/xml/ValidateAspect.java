package com.itwen.spring.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/22 10:59
 * 文件描述：
 */


// 俩切面，所以顺序是？？
@Component

public class ValidateAspect {

    public void beforeMethod(){
        System.out.println("ValidateAspect--->前置通知");
    }
}
