package com.zk.springboot.packet;

public class CommonResult<T> implements IPacket {
    private int code;
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

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public void setCode(int code) {

    }
}
