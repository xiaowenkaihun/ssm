package com.itwen.spring.annotation.impl;

import com.itwen.spring.annotation.Calculator;
import org.springframework.stereotype.Component;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 13:19
 * 文件描述：
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }


}
