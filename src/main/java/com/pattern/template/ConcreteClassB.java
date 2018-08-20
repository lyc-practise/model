package com.pattern.template;

public class ConcreteClassB extends AbstractClass {

    /**
     * 实现了抽象类中的抽象方法，提供部分算法的细化实现
     */
    @Override
    public void primitiveOperate2() {
        System.out.println("concreteClassB primitiveOperate2 is running...");
    }

    /**
     * 提供抽象类中的钩子方法，可反向控制父类的模板方法的业务走向
     * @return
     */
    @Override
    public boolean primitiveOperate3() {
        return true;
    }
}
