package com.zk.springboot.manager;

public class Single {

    private static Single instance;

    private Single() {
        System.out.println("Single被创建");
    }

    public static Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
