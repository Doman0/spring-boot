package com.doman.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/21
 */
@ControllerAdvice
public class MyExceptionHandler {
    public static final String ERROR_VIEW = "error";

    @ExceptionHandler(value=Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();
        if(isAjax(request)){//ajax请求，返回错误信息
            return  new Object();
        }else{//不是ajax请求返回错误页面
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e.getMessage());
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * @description: TODO
     * @params 判断是否是Ajax请求
     * @return: boolean
     * @author: Doman
     * @date: 2020/4/21 15:49
     */
    public static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With")) != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}
