package com.pattern.state;

/**
 * 状态模式
 * 包括
 *  环境类 - 拥有状态的引用，
 *  状态抽象接口（类）
 *  具体状态类
 *
 *  考虑状态的切换问题，解决方式两种
 *  1、由环境类控制，即context类，在类中增加checkState方法，根据不同的value(状态标志)来决定不同的state类
 *  2、由State控制，将context对象传给 state 的handle方法，在handle中更改context的state类
 *
 *
 */

public class Client {


    public static void main(String[] args) {


        Context context = new Context();
        PositiveState positiveState = new PositiveState();
        context.setState(positiveState);

        context.request(1);
        context.request(-2);
        context.request(3);
        context.request(-4);

    }
}
