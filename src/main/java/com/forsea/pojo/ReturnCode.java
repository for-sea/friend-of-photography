package com.forsea.pojo;

/**
 * @program: friend-of-photography
 * @description: 返回码
 * @author: 肖四海
 * @create: 2022-05-18 09:45
 **/
public enum ReturnCode {
    /* 操作失败 */
    RC000(000, "操作失败"),
    /* 操作成功 */
    RC100(100, "操作成功"),
    /* 参数校验错误 */
    RC400(400, "参数校验错误"),
    /* access_denied */
    RC403(403, "用户未授权"),
    /* 路径不存在 */
    RC404(404, "请求路径不存在"),
    /* 服务异常 */
    RC500(500, "系统异常"),

    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(2003, "用户无权限"),
    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    VALID_ERROR(1003, "参数校验错误");

    private final Integer code;
    private final String message;

    ReturnCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
