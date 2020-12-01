package com.zk.springboot.packet;

public class CommonResult<T> implements IPacket {
    private int code;
    private String message = "操作成功";
    private T data;

    public CommonResult() {
    }

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getCode() {
        return 200;
    }

    @Override
    public void setCode(int code) {

    }
}
