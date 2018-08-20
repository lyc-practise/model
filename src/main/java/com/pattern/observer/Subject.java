package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题，被观察者
 */
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();  // 可以是一个，或者一组

    // 注册观察者类
    public void attach(Observer observer){
        observers.add(observer);
    }

    // 去掉观察者类
    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyOberver(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
