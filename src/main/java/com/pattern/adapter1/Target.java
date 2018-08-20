package com.pattern.adapter1;

/**
 * 目标抽象类
 * 也是适配器的抽象接口。客户端调用此接口的实现类，即适配器。最终适配到适配者。
 */
public interface Target {

    void request();   // 处理请求接口
}
