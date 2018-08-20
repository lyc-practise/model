package com.pattern.chain;

public abstract class Handler {

    protected Handler handler;
    public Handler(Handler handler){
        this.handler = handler;
    }
    public Handler(){}

    public abstract void handleRequest();

}
