package com.itwen.spring.annotation;

import com.sun.org.apache.xalan.internal.xsltc.ProcessorVersion;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/21 10:30
 * 文件描述：
 * 在切面当中需要通过指定的注解，将方法标识为通知方法
 * @Before 前置通知，标识在目标对象执行之前执行
 *
 *
 * 切入点表达式：设置在标识通知的注解的value属性当中
 */


@Component
@Aspect // 将当前的类标记为切面类
public class LoggerAspect {


    /**
     * 声明一个公共的切入点表达式
     * 使用方式
     * @After("pointCut()")
     */
    @Pointcut("execution(* com.itwen.spring.annotation.impl.CalculatorImpl.*(..))")
    public void pointCut(){
    }


    //@Before("execution(public int com.itwen.spring.annotation.impl.CalculatorImpl.add(int, int))")
    @Before("pointCut()")
    /**
     * 第一个*表示任意的访问修饰符和返回类型
     * 第二个*表示类中任意的方法
     * ..表示任意的参数列表
     * 类的地方也可以用*，表示包下的所有类
     */
    public void beforeAdviceMethod(JoinPoint joinPoint){
        // 获取连接点所对应的签名信息
        Signature signature = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知，方法:"+signature.getName()+"参数："+ Arrays.toString(args));
    }

    @After("pointCut()")
    // After在目标对象的Finally字句中执行的
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,后置通知，方法:"+signature.getName()+"执行完毕");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    // 在目标对象执行方法之后执行，没有异常的时候才会执行
    // returning设置注解
    // 将通知方法的某个参数（Object 类型）指定为目标对象方法返回值的参数
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,返回通知，方法:"+signature.getName()+"结果："+result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    // 异常通知, 在目标对象的catch子句当中执行，表示目标对象方法执行发生异常
    // 如需要获取目标对象方法执行过程当中发生的异常，需要设置throwing=“”，将此名称设置到通知方法的参数当中
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Throwable ex){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,异常，方法:"+signature.getName()+"发生异常："+ex);
    }

/*    @Around("pointCut()")
    // 环绕通知的返回值要和目标对象的方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;

        // 表示目标方法的执行
        try {
            System.out.println("环绕通知》》》前置通知的位置");
            result = joinPoint.proceed();
            System.out.println("环绕通知》》》返回统治的位置");
        } catch (Throwable e) {
            System.out.println("环绕通知》》》异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知》》》后置通知");
        }
        return result;
    }*/
}
