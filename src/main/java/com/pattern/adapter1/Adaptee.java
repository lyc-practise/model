package com.pattern.adapter1;

/**
 * 适配者类
 * 它包含了一个已经存在的方法，这个方法需要被适配，一般是个具体类。包含了客户希望使用的业务方法。
 */
public class Adaptee {

    public void doRequest(){
        System.out.println("真正操作类在work...");
    }
}
