package com.forsea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: friend-of-photography
 * @description: 返回结果统一封装，采用链式编程
 * @author: 肖四海
 * @create: 2022-05-09 10:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer status; // 返回码
    private String message; // 返回信息
    private Object data; // 数据主体

    // 成功
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setStatus(ReturnCode.RC100.getCode());
        result.setMessage(ReturnCode.RC100.getMessage());
        result.setData(data);
        return result;
    }

    // 失败
    public static Result fail(Integer status, String message){
        Result result = new Result();
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }

    // 设置返回码
    public Result status(Integer status){
        this.setStatus(status);
        return this;
    }

    // 设置返回信息
    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    // 设置数据主体
    public Result data(Object data){
        this.setData(data);
        return this;
    }
}
