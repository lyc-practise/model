package com.pattern.template;

public class ConcreteClassA extends AbstractClass {

    /**
     * 抽象方法，实现抽象类的抽象方法，实现提取出来的部分算法
     */
    @Override
    public void primitiveOperate2() {

        System.out.println("concreteClassA primitiveOperate2 is running....");
    }

    /**
     * 钩子方法，实现抽象类中的钩子方法，可以发过来控制父类的模板方法中的业务走向
     * @return
     */
    @Override
    public boolean primitiveOperate3() {
        return false;
    }
}
