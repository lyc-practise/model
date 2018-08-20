package com.pattern.adapter1;

/**
 * 适配器类
 *
 * 通过实现目标接口，并关联一个适配者类的方式来达到二者产生关联，即适配。
 */
public class Adapter implements Target{

    private Adaptee adaptee ;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("适配器work....");
        adaptee.doRequest();
    }
}
