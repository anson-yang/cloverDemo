package com.anson.common.result;

/**
 * @description: API返回结果实体
 * @author: anson
 * @Date: 2019/12/10 10:54
 */


public class ResultBody<T>
{
    private long code;
    private String message;
    private T data;

    protected ResultBody() {
    }

    protected ResultBody(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultBody<T> success(T data) {
        return new ResultBody<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ResultBody<T> success(T data, String message) {
        return new ResultBody<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ResultBody<T> failed(IErrorCode errorCode) {
        return new ResultBody<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ResultBody<T> failed(long errorCode,String errorMassage)
    {
        return new ResultBody<T>(errorCode, errorMassage, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResultBody<T> failed(String message) {
        return new ResultBody<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultBody<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultBody<T> validateFailed() {
        return failed(ResultCode.NOT_FOUND);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResultBody<T> validateFailed(String message) {
        return new ResultBody<T>(ResultCode.NOT_FOUND.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResultBody<T> unauthorized(T data) {
        return new ResultBody<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultBody<T> forbidden(T data) {
        return new ResultBody<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
