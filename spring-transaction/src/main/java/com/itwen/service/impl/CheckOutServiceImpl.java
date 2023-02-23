package com.itwen.service.impl;

import com.itwen.service.BookService;
import com.itwen.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/23 19:04
 * 文件描述：
 */
@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    private BookService bookService;
    @Override
    /*@Transactional*/
    public void checkOut(Integer userId, Integer[] bookIds) {
        for (Integer bookId :
                bookIds) {
            bookService.buyBook(userId, bookId);
        }
    }
}
