package com.zk.springboot.controller.handler;


import com.zk.springboot.packet.CommonResult;
import com.zk.springboot.packet.IPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    private Logger mLogger = LoggerFactory.getLogger("ErrorLog");

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public IPacket errorHandler(HttpServletRequest request, Exception ex) {

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        ex.printStackTrace();

        mLogger.error(ex.toString());


//        System.out.println("method: " + method + " \t uri: " + uri + "\t queryString: " + queryString);

        return new CommonResult<>(400, ex.toString());
    }
}
