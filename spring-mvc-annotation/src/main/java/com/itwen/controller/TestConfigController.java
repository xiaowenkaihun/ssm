package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/3 21:09
 * 文件描述：
 */
@Controller
public class TestConfigController {
        @RequestMapping("/")
        public String index(){
            return "index";
        }
}
