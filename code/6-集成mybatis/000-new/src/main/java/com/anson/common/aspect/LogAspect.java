package com.anson.common.aspect;

import com.anson.common.exception.BizException;
import com.anson.common.result.ResultCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @description: AOP切面
 * @author: anson
 * @Date: 2019/12/20 10:11
 */

@Aspect //1、添加AOP相关注解
@Component
public class LogAspect
{
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //2、定义切入点（可以匹配、注解的方式，可混用）
//    @Pointcut("execution(public * com.anson.controller.*.*(..))")
@Pointcut("execution(public * com.anson.controller.*.*(..)) && @annotation(com.anson.common.annotation.LogAnnotation)")
  // @Pointcut("execution(public * com.anson.controller.TestController.get*()) && @annotation(com.anson.common.annotation.LogAnnotation)")
    public void pointcut(){}

    //===========通知 多中通知可根据需要灵活选用，一般Before 、AfterReturning即可=======================
    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        //主动抛出自定义异常
        throw new BizException(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage());
    }

    @AfterReturning(returning = "ret",pointcut = "pointcut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
//==============================================
    @After("pointcut()")
    public void commit() {
        logger.info("after commit");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        logger.info("afterThrowing afterThrowing  rollback");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("around");
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            logger.info("around");
        }
    }

}