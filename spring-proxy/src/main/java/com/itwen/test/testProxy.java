package com.itwen.test;

import com.itwen.util.Calculator;
import com.itwen.util.facotory.ProxyFactory;
import com.itwen.util.impl.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 21:51
 * 文件描述：
 */
public class testProxy {

    @Test
    public void testCalculatorProxyOne() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(2, 3);
    }
}
