package com.pattern.observer;

/**
 * 具体被观察者类。
 * 当被观察者类的状态发生变更时，通知观察者类
 */
public class ConcreteSubject extends Subject {

    private int state;

    public void setState(int state){
        this.state = state;
        notifyOberver();
    }

    @Override
    public void notifyOberver() {
        for(Observer observer : observers){
            observer.update();
        }
    }
}
