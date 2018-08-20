package com.pattern.facade1;

/**
 * 外观类，外观类持有子系统的引用。子系统通过外观类对外以统一的方式展示。
 * 通过外观类屏蔽了业务方和具体的子系统产生关联。
 * 当某子系统添加和移除时，可尽量避免对业务类的修改。只需要修改子系统和外观类。相对而言，改动量不是很大
 *
 * 引入抽象外观类，业务端不在持有具体的外观类引用，具体引用在运行时指定。方便子系统与外观类的替换维护。
 */
public class Facade {

    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    public void request(){
        subSystem1.request();
        subSystem2.request();
        subSystem3.request();
    }
}





