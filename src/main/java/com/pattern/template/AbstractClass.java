package com.pattern.template;

/**
 * 抽象方法
 */

public abstract class AbstractClass {

    /**
     * 模板方法
     */
    public void templateMethod(){

        if(primitiveOperate3()){
            primitiveOperate1();
        }else{
            primitiveOperate2();
        }
    }

    /**
     * 具体方法
     */

    public void primitiveOperate1(){
        System.out.println("抽象 具体方法");
    }
    /**
     * 基本方法
     */
    public abstract void primitiveOperate2();

    /**
     * 钩子方法
     */
    public abstract boolean primitiveOperate3();


}
