package com.zk.springboot.design.observermode.impl;

import com.zk.springboot.design.observermode.inter.Observer;
import com.zk.springboot.design.observermode.inter.Subject;

import java.util.ArrayList;
import java.util.List;

public class RealSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyChanged() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
