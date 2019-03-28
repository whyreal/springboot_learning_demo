package com.example.demo.exception;

import com.example.demo.vo.Error;
import com.example.demo.vo.Result;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice 
 */
@RestControllerAdvice
class GlobalControllerExceptionHandler {

    // 设置 http 状态码
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /**
     * 注册一个全局的错误处理方法
     * 
     * 在代码中的任何位置，不管是 controller、dao 还是 service 层，只要遇到需要结束当前请求的 Exception
     * 都不需要手动捕获，由全局错误处理函数统一处理
     * 
     * 好处是可以减少代码量，同时可以保证返回结果格式的统一
     * 
     * 可以设置需要捕获的错误类型
     */
    @ExceptionHandler(value = BindException.class) 
    public Result handleConflict(BindException ex) {
        return new Result(
            null,
            new Error(ParamsException.code, ex.getMessage()));
    }

    // @ExceptionHandler(value = OtherException.class) 
    // public Result handleConflict(Exception ex) {
    //     return new Result(ex.toString());
    // }
}