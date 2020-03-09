package com.anson.common.exception;

import com.anson.common.result.ResultBody;
import com.anson.common.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 全局异常处理类
 * @author: anson
 * @Date: 2019/12/10 20:56
 */

@ControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 1、处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public  ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
        logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultBody.failed(e.getErrorCode(),e.getErrorMsg());
       // return ResultBody.failed(e.getErrorCode());
    }


    /**
     * 2、处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e)
    {
//1、写日志及其他处理，对内

        logger.error("未知异常！原因是:",e);
        System.out.println("未知异常！原因是:"+e);
//------------------------
//        boolean a = false;
//        String filename = file.getOriginalFilename();
//        System.out.println("++++++++++++文件名++++++++"+filename);

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");

        long beginTime = System.currentTimeMillis();
        logger.info("请求处理结束，耗时：{}毫秒", (System.currentTimeMillis() - beginTime));    //第一种用法
        logger.info("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime)  + "毫秒");    //第二种用法
//------------------------------

//2、返回错误识别码和提示给API调用者、对外
        return ResultBody.failed(ResultCode.FAILED);
    }
}
