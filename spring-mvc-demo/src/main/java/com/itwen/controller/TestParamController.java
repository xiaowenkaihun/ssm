package com.itwen.controller;

import com.itwen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/30 10:38
 * 文件描述：
 */

/**
 * 在控制器方法中设置HttpServletRequest request的形参
 * 就可以使用request对象获取请求参数
 */


@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "success";
    }

    /**
     * 下控制器方法中设置形参，保证形参的名字要和请求参数的名字一致
     * @param username
     * @param password
     * @return
     *
     * @RequestParam 把请求参数和控制器方法的形参进行绑定
     * @RequestHeader 把请求头信息和控制器方法的新参进行绑定
     * @CookieValue 把cookie数据和控制器的方法新参进行绑定
     *
     *
     * 需要在控制器方法的形参位置设置实体类类型的形参。要保证实体类中的属性名和请求参数的名字一致
     */
    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = true, defaultValue = "lisi")String username,
            String password,
            @RequestHeader(value = "referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("referer:"+referer);
        System.out.println("sessionID:"+jsessionId);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }




}
