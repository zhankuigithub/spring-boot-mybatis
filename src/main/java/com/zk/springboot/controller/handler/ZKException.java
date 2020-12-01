package com.zk.springboot.controller.handler;

public class ZKException extends RuntimeException {

    private int code;
    private String msg;

    public ZKException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ZKException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
