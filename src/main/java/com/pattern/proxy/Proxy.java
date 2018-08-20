package com.pattern.proxy;


/**
 * 代理类
 *
 * 此类作为 RealSubject 的代理类。持有 RealSubject 类的引用。
 * 在 doRequest 方法执行时调用 RealSubject 类的 doRequest 方法来执行
 */
public class Proxy implements Subject{

    private Subject subject = new RealSubject();

    @Override
    public void doRequest() {

        System.out.println("proxy doRequest");
        subject.doRequest();

    }
}
