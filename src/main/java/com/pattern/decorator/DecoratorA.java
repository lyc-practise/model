package com.pattern.decorator;

/**
 * 具体装饰类，继承装饰抽象类。持有具体组件类引用
 */
public class DecoratorA extends AbstractDecorator {

    public DecoratorA(Component component){
        super(component);
    }

    public void operation() {
        System.out.println("decoratorA operation");
        getComponent().operation();

    }
}
