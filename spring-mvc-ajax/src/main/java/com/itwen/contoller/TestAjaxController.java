package com.itwen.contoller;

import com.itwen.pojo.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/1 11:13
 * 文件描述：
 * 1. @RequestBody: 将请求体中的内容和控制器的方法进行绑定
 * 接收JSON数据
 * 2, 使用@RequestBody注解，将json格式的请求参数转换为java对象
 *   a， 导入jackson的jar包
 *   b， 在springMVC的配置文件中设置<mvc:annotation-driven/>
 *   c，在处理请求的控制方法的形参位置，直接设置json格式的请求参数要转换的java类型的形参，使用
 *   @RequestBody 注解标识即可
 */
@Controller
// @RestController
// 相当于@Controller和@ResponseBody
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id: "+id);
        System.out.println("requestBody: "+requestBody);
        response.getWriter().write("hello,axios");
    }

    // @RequestMapping(value = "/test/RequestBody/json", method = RequestMethod.POST)
    public void testRequestBody(HttpServletResponse response, @RequestBody User user) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello.json use Javabean");
    }


    // 没有实体就可以使用Map进行接收
    @RequestMapping(value = "/test/RequestBody/json", method = RequestMethod.POST)
    public void testRequestBodyMap(HttpServletResponse response, @RequestBody Map<String, Object> map) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello.json use map");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    // 将方法的返回值作为响应报文的响应体
    // 我们的响应一般为一个java对象，其实还是转化为json的格式，浏览器才能识别
    public String testResponseBody(){

        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    // 实体类-->json对象
    // map-->json对象
    // list-->json数组
    /*public User testResponseBodyJson(){
        User user = new User(1002, "admin", "123242", 23, "女");
        return user;
    }*/
    /*public Map<String, Object> testResponseBodyJson(){
        User user1 = new User(1001, "admin", "123242", 23, "女");
        User user2 = new User(1002, "admin", "123242", 23, "女");
        User user3 = new User(1003, "admin", "123242", 23, "女");
        Map<String, Object> map = new HashMap<>();
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);
        return map;
    }*/
    public List<User> testResponseBodyJson(){
        User user1 = new User(1001, "admin", "123242", 23, "女");
        User user2 = new User(1002, "admin", "123242", 23, "女");
        User user3 = new User(1003, "admin", "123242", 23, "女");
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }
}
