package com.pattern.chain;

/**
 * 责任链模式
 */
public class Client {

    public static void main(String[] args) {
        Handler handler = new ConcreteHandlerA(new ConcreteHandlerB());

        handler.handleRequest();
    }
}
