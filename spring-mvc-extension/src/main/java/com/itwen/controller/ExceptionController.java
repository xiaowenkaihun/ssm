package com.itwen.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/3 20:23
 * 文件描述：
 */
// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {
    // 这个控制方法出现了异常，怎么办
    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleException(Throwable ex){
        ModelAndView modelAndView = new ModelAndView();
        // 当前的ex表示控制器方法所出现的异常
        modelAndView.addObject("ex", ex);
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
