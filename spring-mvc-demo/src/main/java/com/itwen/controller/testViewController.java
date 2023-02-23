package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/31 10:28
 * 文件描述：
 */
@Controller
public class testViewController {
@RequestMapping("view/thymeleaf")
    public String testThymeleaf(){
    return "success";//试图名称
}

    @RequestMapping("view/forward")
    public String testResourceView(){
        return "forward:/test/model";//转发请求（几乎不使用）
    }

    @RequestMapping("view/redirect")
    public String testRedirectView(){
        return "redirect:/test/model";//重定向，springMVC在前面自动加上上下文路径
    }


}
