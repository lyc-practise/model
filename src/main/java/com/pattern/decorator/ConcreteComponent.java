package com.pattern.decorator;

/**
 * 具体组件类，与装饰抽象类共同实现抽闲接口
 */
public class ConcreteComponent  implements  Component{
    @Override
    public void operation() {
        System.out.println("concreteComponent operation!");
    }
}
