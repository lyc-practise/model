package com.reflect;

import sun.rmi.rmic.iiop.ClassPathLoader;
import sun.tools.java.ClassPath;

public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader loader = new ClassPathLoader(new ClassPath("com.reflect"));

        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());


    }
}
