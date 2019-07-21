package com.cy.zhnews.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandlerRuntimeException(Throwable e){
        System.out.println(e);
        return new JsonResult(e);
    }

    @ExceptionHandler(BindException.class)
    public JsonResult doBind(BindException e){
        return new JsonResult(e);
    }

}
