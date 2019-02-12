package com.xyk.springboot.controller;

import com.xyk.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {
    //处理制定的Exception
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object>  handleException(Exception e){
//        Map<String,Object> map = new HashMap<> ();
//
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage ());
//
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest req){
        Map<String,Object> map = new HashMap<> ();
        //传入自己的错误状态吗
        req.setAttribute ("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","用户出错啦");
        req.setAttribute ("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
