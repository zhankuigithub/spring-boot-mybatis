package com.zk.springboot.proxy.staticproxy;

public class TeachDao implements ITeachDao {
    @Override
    public void teach() {
        System.out.println("正在上课");
    }
}
