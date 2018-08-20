package com.pattern.bridge;


/**
 * 抽象部分的抽象类，一般是抽象类而不是接口
 *
 * 含有实现部分的引用
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public void setImplementor(Implementor implementor){
        this.implementor = implementor;
    }

    public abstract void operate();

}
