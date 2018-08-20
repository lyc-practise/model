package com.pattern.bridge;

/**
 * 桥接模式
 *
 * 桥接模式
 *
 *  将抽象部分和实现部分分离，他们可以独自演化
 *
 *  个人感觉：抽象部分更像实现部分的整体，实现部分为局部。当遇到整理和局部都是多样化时，用桥接模式。既保证了抽象和实现部分的独立性。
 *  又节省了大量的类和代码。
 */
public class Client {

    public static void main(String[] args) {

        Abstraction abstraction = new RefinedAbstraction();
        Implementor implementorA = new ConcreteImplementorA();
        Implementor implementorB = new ConcreteImplementorB();
        abstraction.setImplementor(implementorA);
        abstraction.operate();
        abstraction.setImplementor(implementorB);
        abstraction.operate();
    }
}
