package com.forsea.handler;

import com.forsea.pojo.Result;
import com.forsea.pojo.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * @program: friend-of-photography
 * @description: 全局异常统一处理
 * @author: 肖四海
 * @create: 2022-05-10 12:09
 **/
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /* 默认全局异常处理 */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception e){
        log.error("全局异常信息: ex={}", e.getMessage(), e);
        return Result.fail(ReturnCode.RC500.getCode(), ReturnCode.RC500.getMessage());
    }

    /* 请求路径不存在异常处理 */
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseBody
    public Result noHandlerFoundException(HttpServletRequest req, Exception e) {
        log.warn("全局异常信息: ex={}",e.getMessage(), e);
        return Result.fail(ReturnCode.RC404.getCode(), ReturnCode.RC404.getMessage());
    }


    /* 参数校验异常处理 */
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Result<String>> handleValidatedException(Exception e) {
        Result<String> resp = null;

        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            resp = Result.fail(HttpStatus.BAD_REQUEST.value(),
                    ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            resp = Result.fail(HttpStatus.BAD_REQUEST.value(),
                    ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof BindException) {
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            resp = Result.fail(HttpStatus.BAD_REQUEST.value(),
                    ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        }

        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }
}
