package com.pattern.template;

/**
 * 模板模式
 *
 * 针对算法结构不变，但具体算法的业务实现不同，通过模板模式，将细化的算法实现放在子类中。通过不同的子类，使算法实现多样化。
 *
 * 抽象类中的方法可分为以下：
 *  模板方法：实现了业务方法的主体结构，该主体结构对于不同的实现类是一致的。
 *  具体方法
 *  抽象方法
 *  钩子方法：一般返回的是true/false，通过返回值反向控制抽象类中模板方法的业务逻辑。
 *
 */
public class Client {

    public static void main(String[] args) {

        AbstractClass abstractClass1 = new ConcreteClassA();
        abstractClass1.templateMethod();

        AbstractClass abstractClass2 = new ConcreteClassB();
        abstractClass2.templateMethod();
    }
}
