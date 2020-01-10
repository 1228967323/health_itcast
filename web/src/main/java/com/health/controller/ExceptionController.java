package com.health.controller;

import com.health.comment.MessageConstant;
import com.health.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LiuJunShi
 * @create 2020/1/10 21:20
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e){
        return new Result(false, MessageConstant.Exception);
    }
}
