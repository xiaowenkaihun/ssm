package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/31 17:10
 * 文件描述：
 * /user同一路径
 * 查询所有的用户信息 /user-->get
 * 根据id查询用户的信息 /user/1-->get
 * 添加用户信息 /user-->post
 * 修改用户信息 /user-->put
 * 删除用户信息 /user/1-->delete
 */
@Controller
public class TestRestController {
    @GetMapping("/user")
    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息 /user-->get ");
        return "success";
    }
    @GetMapping("/user/{id}")
    // @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户的信息 /user/"+id+"-->get");
        return "success";
    }
    @PostMapping("/user")
    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息 /user-->post");
        return "success";
    }

    /**
     * 注意：浏览器目前只能发送post和get请求
     * 若要发送put请求和delete请求,需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
     * @return
     */
    @PutMapping("/user")
    // @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息 /user-->put");
        return "success";
    }
    @DeleteMapping("/user/{id}")
    // @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("修改用户信息 /user-->put"+id+"");
        return "success";
    }
}
