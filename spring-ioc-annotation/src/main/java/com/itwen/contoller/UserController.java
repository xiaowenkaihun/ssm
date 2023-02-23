package com.itwen.contoller;

import com.itwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 10:44
 * 文件描述：
 */
@Controller("controller")
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;



    public void saverUser(){
         userService.saveUser();
     }
}
