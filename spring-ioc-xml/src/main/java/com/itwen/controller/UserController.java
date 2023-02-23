package com.itwen.controller;

import com.itwen.service.UserService;
import com.itwen.service.impl.UserServiceImpl;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 20:58
 * 文件描述：
 */
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
