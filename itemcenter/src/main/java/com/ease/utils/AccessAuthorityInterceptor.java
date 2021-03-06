package com.ease.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.method.HandlerMethod;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
自定义拦截器实现对请求接口的安全验证
 */
public class AccessAuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AccessAuthority auth = null;
        String loginName = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod methodHandler = (HandlerMethod) handler;
            loginName = (String) request.getSession().getAttribute("loginName");
            auth = methodHandler.getMethodAnnotation(AccessAuthority.class);
        }
        if (auth == null) {
            return true;
        }
        if (auth.isBuyer() && ObjectUtils.equals(loginName, "buyer")) {
            return true;
        }
        if (auth.isSeller() && ObjectUtils.equals(loginName, "seller")) {
            return true;
        }
        throw new Exception("非法访问");
    }

}

