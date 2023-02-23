package com.itwen.controller;

import com.itwen.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/5 9:42
 * 文件描述：
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

}
