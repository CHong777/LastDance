package com.example.lastdance.aop;

import com.example.lastdance.domain.res.RootRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class AopExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    Object handleException(Exception e){
        log.error("ERR: " + e.toString(), e);
        return new RootRes("F9999");
    }
}
