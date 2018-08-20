package com.pattern.observer;

/**
 * 具体观察者类
 * 当被观察类的状态发生变更时，收到通知的观察者类，做出相应的应对操作。
 */
public class ConcreteObserverA implements Observer {


    @Override
    public void update() {
        System.out.println("concreteObserverA is operate");
    }
}
