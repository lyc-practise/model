package com.pattern.policy;

public class Context {


    public void operate(Strategy strategy){
        strategy.algorithm();
    }
}
