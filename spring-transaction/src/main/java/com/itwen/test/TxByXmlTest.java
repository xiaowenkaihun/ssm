package com.itwen.test;

import com.itwen.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/23 16:26
 * 文件描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXmlTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1, 2 );
    }


    @Test
    public void testBuyMoreBook(){
        bookController.checkOut(1, new Integer[]{1, 2});
    }
}
