package com.pattern.policy;

public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("strategy B is running");
    }
}
