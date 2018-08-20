package com.pattern.bridge;

/**
 * 扩充抽象类，实现了抽象类的业务部分。
 *
 * 因继承了抽象类，所以拥有实现类的引用
 *
 * 根据业务需要调用不同的具体实现类
 */

public class RefinedAbstraction extends Abstraction{

    @Override
    public void operate() {
        if(implementor != null){
            implementor.operateImpl();
        }
    }
}
