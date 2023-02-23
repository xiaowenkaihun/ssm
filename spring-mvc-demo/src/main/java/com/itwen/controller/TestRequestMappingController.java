package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/25 17:11
 * 文件描述：
 */

/**
 * @RequestMapping 的value属性是一个数组，只要访问的路径满足其中一个
 * 则当前请求就会被注解所标识的方法进行处理
 *
 * @RequestMapping 的method属性也是一个数组，只要访问的请求方式满足method里面的任何一种方式
 * 则当前请求就会被注解所标识的方法进行处理
 * 若value匹配方式不匹配则会报错：  Request method 'GET' not supported
 *
 * @RequestMapping 的基础上衍生出
 * @GetMapping,@PostMapping,@PutMapping,@DeleteMapping
 *
 * @RequestMapping 的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * "param"  必须携带
 * "!param" 不能携带
 * "param=value" 必须等于
 * "param!=value" 必须不等于
 *
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/a?a/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        return "success";
    }
}
