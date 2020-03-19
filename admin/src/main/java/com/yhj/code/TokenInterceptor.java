package com.yhj.code;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yhj.code.kit.StrKit;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

@Component
public class TokenInterceptor implements  HandlerInterceptor{
	private Log logger = LogFactory.get();
	private String accessToken = "";
	private String platform = "";// 接入平台类型 1：android 2:IOS 3：iPad 4:PC
	/**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    	accessToken = request.getHeader("accessToken");
    	platform = request.getHeader("platform");
//    	if(StrKit.isBlank(accessToken)) {
//    		response.setStatus(500);
//    	    response.getWriter().append("accessToken不能为空");
//    		return false;
//    	}
    	return true;
    }
 
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }
 
    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }
}
