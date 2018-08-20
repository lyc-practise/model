package com.pattern.adapter1;

/**
 * 适配器模式 -- 单向适配器模型
 *
 * 当 Client 与 Adaptee 不适配时，通过 Adapter 类达到适配，真正的操作类为 Adaptee 类。
 * 屏蔽了 目标抽象类 与 Adaptee 的差异。
 */
public class Client {

    public static void main(String[] args) {

        Target target = new Adapter(new Adaptee());
        target.request();

    }
}
