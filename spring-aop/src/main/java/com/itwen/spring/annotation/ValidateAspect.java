package com.itwen.spring.annotation;

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
@Aspect
@Order(1)
// 使用Order，数字越小，优先级越高
public class ValidateAspect {
    @Pointcut("execution(* com.itwen.spring.annotation.impl.CalculatorImpl.*(..))")
    public void pointCut(){}


    @Before("pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect--->前置通知");
    }
}
