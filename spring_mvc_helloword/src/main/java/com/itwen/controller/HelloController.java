package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/25 15:51
 * 文件描述：
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    // 这个斜线代表http://localhost:8080/spring_mvc_helloword/
    public String protal(){
        // 讲逻辑返回
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
