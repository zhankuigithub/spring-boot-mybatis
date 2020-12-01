package com.zk.springboot.design.observermode.impl;

import com.zk.springboot.design.observermode.inter.Observer;

public class RealObject implements Observer {
    @Override
    public void update() {
        System.out.println("接收到了通知");
    }
}
