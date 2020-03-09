package com.anson.common.exception;

import com.anson.common.result.IErrorCode;

/**
 * @description: 自定义异常类
 * @author: anson
 * @Date: 2019/12/30 9:14
 */
public class BizException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    protected long errorCode;  //错误码
    protected String errorMsg;  //错误信息

    //构造1
    public BizException()
    {
        super();
    }
    //构造2
    public BizException(IErrorCode errorInfoInterface) {
        super(String.valueOf(errorInfoInterface.getCode()));
        this.errorCode = errorInfoInterface.getCode();
        this.errorMsg = errorInfoInterface.getMessage();
    }

    public BizException(IErrorCode errorInfoInterface, Throwable cause) {
        super(String.valueOf(errorInfoInterface.getCode()), cause);
        this.errorCode = errorInfoInterface.getCode();
        this.errorMsg = errorInfoInterface.getMessage();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(long errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(long errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}