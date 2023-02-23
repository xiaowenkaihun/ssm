package com.itwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/30 22:09
 * 文件描述：
 */

@Controller
public class testScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和view的功能
         * Model：向请求域中共享
         * View: 设计试图向页面跳转
         */
        ModelAndView mav = new ModelAndView();
        System.out.println(mav.getClass().getName());
        // org.springframework.web.servlet.ModelAndView
        // 向请求域共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        // 设计逻辑试图
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        System.out.println(model.getClass().getName());
        // org.springframework.validation.support.BindingAwareModelMap
        model.addAttribute("testRequestScope","hello,Model");
        return "success";

    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName());
        // org.springframework.validation.support.BindingAwareModelMap
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";

    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName());
        // org.springframework.validation.support.BindingAwareModelMap
        map.put("testRequestScope","hello,Map");
        return "success";

    }

    // 重启服务器session不会消失
    // session的钝化与活化
    @RequestMapping("/test/session")
    public String testSession(HttpSession httpSession){
        System.out.println(httpSession.getClass().getName());
        httpSession.setAttribute("testSessionScope","hello,Session");
        return "success";

    }
    @RequestMapping("/test/application")
    public String testApplication(HttpSession httpSession){
        System.out.println(httpSession.getClass().getName());
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("testSessionScope","hello,Application");
        return "success";

    }




}
