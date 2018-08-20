package com.pattern.adapter2;

/**
 * 双向适配器模式
 *
 *
 */
public class Client2 {

    public static void main(String[] args) {

        Adaptee1 adaptee1 = new Adaptee1();
        Adaptee2 adaptee2 = new Adaptee2();

        Target2 target2 = new Adapter(adaptee1, adaptee2);

        target2.server();

    }
}
