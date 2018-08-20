package com.pattern.decorator;

/**
 * 装饰器抽象类，装饰器类继承该类，并持有具体组件类对象。
 */
public abstract class AbstractDecorator implements Component {

    private Component component ;

    public AbstractDecorator(Component component){
        this.component = component;
    }

    public abstract  void operation();

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}
