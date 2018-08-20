package com.pattern.bridge;

public class ConcreteImplementorB implements Implementor {

    @Override
    public void operateImpl() {
        System.out.println("concreteImplementorB is operating!");
    }
}
