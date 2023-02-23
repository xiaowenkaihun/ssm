package com.itwen.proxy;

import com.itwen.util.Calculator;
import com.itwen.util.impl.CalculatorImpl;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 21:47
 * 文件描述：
 */
public class CalculatorStaticProxy implements Calculator {

    private CalculatorImpl calculator;

    public CalculatorStaticProxy(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        int result = 0;
        try {
            System.out.println("日志，方法：add，参数"+i+","+"j");
            result = calculator.add(i, j);
            System.out.println("方法内部："+result);
            System.out.println("日志，方法：add，结果"+result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法：sub，参数"+i+","+"j");
        int result = calculator.sub(i, j);
        System.out.println("方法内部："+result);
        System.out.println("日志，方法：sub，结果"+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法：mul，参数"+i+","+"j");
        int result = calculator.mul(i, j);
        System.out.println("方法内部："+result);
        System.out.println("日志，方法：mul，结果"+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法：div，参数"+i+","+"j");
        int result = calculator.div(i, j);
        System.out.println("方法内部："+result);
        System.out.println("日志，方法：div，结果"+result);
        return result;
    }

}
