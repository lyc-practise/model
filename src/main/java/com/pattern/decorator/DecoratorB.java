package com.pattern.decorator;


public class DecoratorB extends AbstractDecorator {

    public DecoratorB(Component component){
        super(component);
    }

    public void operation() {
        System.out.println("decoratorB operate!");
        getComponent().operation();
    }
}
