package com.zk.springboot.design.observermode.inter;

/**
 * 被观察者
 */
public interface Subject {
    /**
     * 订阅操作
     */
    void attach(Observer observer);

    /**
     * 取消订阅操作
     */
    void detach(Observer observer);

    /**
     * 通知变动
     */
    void notifyChanged();
}
