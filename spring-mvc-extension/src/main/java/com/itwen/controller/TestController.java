package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/1 16:07
 * 文件描述：
 */
@Controller
public class TestController {
    @RequestMapping("/test/hello")
    public String testHello(){
        System.out.println(1/0);
       return "success";
    }
}
