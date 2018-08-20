package com.pattern.adapter2;

/**
 * 双向适配器模式
 *
 *
 */
public class Client1 {

    public static void main(String[] args) {

        Adaptee1 adaptee1 = new Adaptee1();
        Adaptee2 adaptee2 = new Adaptee2();

        Adapter adapter = new Adapter(adaptee1, adaptee2);
        adapter.request();
    }
}
