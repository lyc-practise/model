package com.reflect;

public class ClassAndClassRelation {



    // 内部类
    class InnerCls{}

    // 静态内部类
    static class StaticInnerCls{}

    // 方法内部类

    interface Inf{}

    public static Inf getInf(){
        class InfImp implements Inf{
        }

        return null;
    }


}
