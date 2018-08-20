package com.pattern.observerJdk;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("收到对象【"+o+"】的变更信号，arg:"+arg);
    }
}
