package com.anson.common.listener;

import com.anson.common.exception.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/20 6:48
 */
@WebListener
public class OnlineSessionListener implements  ServletContextListener  //HttpSessionListener
{
    private static final Logger logger = LoggerFactory.getLogger(OnlineSessionListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        logger.info("系统启动了");
        System.out.println("系统启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        logger.info("系统停止了");
        System.out.println("系统停止了");
    }

    //=============================
//    public  static int online=0;
//
//    @Override
//    public void sessionCreated(HttpSessionEvent httpSessionEvent)
//    {
//
//        online ++;
//        logger.info("有用户上线了,当前在线人数：" + online);
//        System.out.println("有用户上线了,当前在线人数：" + online);
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)
//    {
//        online --;
//        logger.info("有用户下线了,当前在线人数：" + online);
//        System.out.println("有用户下线了,当前在线人数：" + online);
//    }
}
