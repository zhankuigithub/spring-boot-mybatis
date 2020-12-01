package com.zk.springboot.design.observermode;

import com.zk.springboot.design.observermode.impl.RealObject;
import com.zk.springboot.design.observermode.impl.RealSubject;
import com.zk.springboot.design.observermode.inter.Observer;
import com.zk.springboot.design.observermode.inter.Subject;

import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();

        Subject subject = new RealSubject();
        Observer observer1 = new RealObject();
        Observer observer2 = new RealObject();

        subject.attach(observer1);
        subject.attach(observer2);
        subject.notifyChanged();
    }
}
