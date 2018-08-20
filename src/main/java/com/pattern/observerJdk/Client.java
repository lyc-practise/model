package com.pattern.observerJdk;

import java.util.Observer;

public class Client {

    public static void main(String[] args) {

        ConcreteObservable observable = new ConcreteObservable();
        Observer observer = new ConcreteObserver();
        observable.addObserver(observer);
        observable.setState(1);
    }
}
