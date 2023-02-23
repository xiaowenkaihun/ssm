package com.itwen.controller;

import com.itwen.service.BookService;
import com.itwen.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/23 16:06
 * 文件描述：
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckOutService checkOutService;


    public void buyBook(Integer userId, Integer bookId){
        bookService.buyBook(userId, bookId);
    }

    public void checkOut(Integer userId, Integer[] bookIds){
        checkOutService.checkOut(userId,bookIds);
    }
}
