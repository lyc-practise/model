package com.pattern.observerJdk;

import java.util.Observable;

public class ConcreteObservable extends Observable {

    public int state;

    public void setState(int state){
        this.state = state;
        setChanged();   // 需要设置变更信号
        notifyObservers(state);
    }
}
