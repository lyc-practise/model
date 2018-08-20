package com.pattern.observer;

public class Client {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        Observer observerA = new ConcreteObserverA();
        Observer observerB = new ConcreteObserverB();

        subject.setState(1); //在没有注册观察者时。被观察者状态的变更不会对观察者造成影响

        subject.attach(observerA);
        subject.attach(observerB);

        subject.setState(2);
    }
}
