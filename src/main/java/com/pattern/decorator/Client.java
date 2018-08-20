package com.pattern.decorator;

/**
 * 装饰器模式
 */
public class Client {

    public static void main(String[] args) {

        AbstractDecorator decorator = new DecoratorA(new DecoratorB(new ConcreteComponent()));

        decorator.operation();

    }
}
 