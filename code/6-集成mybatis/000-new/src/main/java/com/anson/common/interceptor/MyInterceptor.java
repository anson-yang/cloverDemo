package com.anson.common.interceptor;

import com.anson.common.exception.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 拦截器
 * @author: anson
 * @Date: 2019/12/20 7:23
 */

@Component
public class MyInterceptor implements HandlerInterceptor
{
    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception
    {
        logger.info("afterCompletion被调用");
        long startime = (Long) arg0.getAttribute("startime");
        logger.info("请求耗时："+ (System.currentTimeMillis() - startime));
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception
    {
        logger.info("postHandle被调用");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        logger.info("preHandle被调用");
        request.setAttribute("startime",System.currentTimeMillis());
        return true;
    }
}
