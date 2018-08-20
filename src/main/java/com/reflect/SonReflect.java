package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SonReflect {

    public static void main(String[] args) {


        Class sonCls = Son.class;

        Method[] sonMethods = sonCls.getMethods();
        Method[] sonDecMethods = sonCls.getDeclaredMethods();

        System.out.println("-------method-------");
        Arrays.asList(sonMethods).forEach(method ->
                System.out.println(method.getName())
        );

        System.out.println("-----------");
        Arrays.asList(sonDecMethods).forEach(method ->
                System.out.println(method.getName())
        );


        System.out.println("----------filed---------");

        Field[] sonFields = sonCls.getFields();
        Field[] sonDecFields = sonCls.getDeclaredFields();

        Arrays.asList(sonFields).forEach(field ->
                System.out.println(field.getName())
        );

        System.out.println("-----------------");
        Arrays.asList(sonDecFields).forEach(field ->
                System.out.println(field.getName())
        );

    }
}


