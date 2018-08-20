package com.pattern.policy;

public class Client {


    public static void main(String[] args) {


        Context context = new Context();

        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();

        context.operate(strategyA);

        context.operate(strategyB);

    }
}
