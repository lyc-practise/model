package com.pattern.proxy;


/**
 * 实际主题类。
 *
 * 此类做实际的操作
 */
public class RealSubject implements  Subject {
    @Override
    public void doRequest() {
        System.out.println("real do request");
    }
}
