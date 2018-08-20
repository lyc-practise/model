package com.pattern.bridge;

/**
 * 具体实现类
 */
public class ConcreteImplementorA implements Implementor{
    @Override
    public void operateImpl() {
        System.out.println("concreteImplementorA is operating!");
    }
}
