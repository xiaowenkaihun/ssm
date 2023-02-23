package com.itwen.impl;

import com.itwen.Calculator;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 22:25
 * 文件描述：
 */
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
