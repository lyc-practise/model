package com.pattern.adapter2;

public class Adapter implements Target1 , Target2{

    private Adaptee1 adaptee1;
    private Adaptee2 adaptee2;

    public Adapter(Adaptee1 adaptee1, Adaptee2 adaptee2){
        this.adaptee1 = adaptee1;
        this.adaptee2 = adaptee2;
    }

    @Override
    public void request() {
        System.out.println("适配器类，request...");
        adaptee2.doRequst();

    }

    @Override
    public void server() {
        System.out.println("适配器类，server...");
        adaptee1.doServer();
    }
}
