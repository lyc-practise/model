package com.pattern.chain;

public class ConcreteHandlerA extends Handler {

    public ConcreteHandlerA(Handler handler){
        super(handler);
    }
    public ConcreteHandlerA(){}

    @Override
    public void handleRequest() {
        System.out.println("concreteHandlerA handle request!");
        if(handler != null){
            handler.handleRequest();
        }

    }
}
