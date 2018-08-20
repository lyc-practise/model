package com.test;

/**
 * 测试
 *
 * new Object()
 * 与
 * new Object(){}
 * 写法的区别
 *
 */
public class NewObject {

    public static void main(String[] args) {
        Object obj = new Object();
        Object obj1 = new Object(){};

        System.out.println(obj.getClass() == obj1.getClass());
        System.out.println(obj1 instanceof Object);
        System.out.println(obj1.getClass().getSuperclass() == obj.getClass());
    }


}
