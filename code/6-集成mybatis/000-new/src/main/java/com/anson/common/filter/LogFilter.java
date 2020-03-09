package com.anson.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @description: 过滤器
 * @author: anson
 * @Date: 2019/12/20 6:03
 */

@WebFilter(filterName = "logfilter1", urlPatterns = "/*")
public class LogFilter implements Filter
{
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

        logger.info("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponseWrapper resp = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);

        String requestURI = req.getRequestURI();
        logger.info("--------------------->过滤器：请求地址"+requestURI); //记录请求
        if(requestURI.contains("info")){
           // servletRequest.getRequestDispatcher("/failed").forward(servletRequest, servletResponse);
            resp.sendRedirect("/failed");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

        logger.info("----------------------->过滤器被销毁");
    }
}
