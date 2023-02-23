package com.itwen.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/1 16:15
 * 文件描述：
 * preHandle():在控制器方法执行之前执行，其返回值表示的是对控制器方法的拦截(false)或(true)放行
 * postHandle():在控制器方法执行之后执行
 * afterCompletion(): 在控制器方法执行之后，且渲染视图完毕之后执行
 */
@Component
public class SecondInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SecondInterceptor-->preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SecondInterceptor-->postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("SecondInterceptor-->afterHandle");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
