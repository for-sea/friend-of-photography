package com.forsea.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forsea.pojo.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: friend-of-photography
 * @description: 全局统一处理返回格式
 * @author: 肖四海
 * @create: 2022-05-18 09:34
 **/
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }


    /* 返回结果统一封装处理 */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String){
            return objectMapper.writeValueAsString(Result.success(body));
        }
        // 若全局异常处理已封装好，则直接返回
        if (body instanceof Result){
            return body;
        }
        return Result.success(body);
    }
}
