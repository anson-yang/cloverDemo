package com.anson.common.result;

/**
 * @Author anson
 * @Description 结果消息枚举
 * @Date 2019/12/10 22:05
*/
public enum ResultCode  implements IErrorCode
{
    // 数据操作消息定义
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    UNAUTHORIZED(401,"暂未登录或token已经过期!"),
    FORBIDDEN(403, "没有相关权限"),
    NOT_FOUND(404, "未找到该资源!"),
    FAILED(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
