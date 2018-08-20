package com.pattern.chain;

public class ConcreteHandlerB extends Handler{

    public ConcreteHandlerB(Handler handler){
        super(handler);
    }
    public ConcreteHandlerB(){}

    public void handleRequest(){
        System.out.println("concreteHandlerB handle request!");
        if(handler != null){
            handler.handleRequest();
        }
    }


}
