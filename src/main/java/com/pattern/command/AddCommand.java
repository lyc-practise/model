package com.pattern.command;

/**
 * 具体命令类
 * 实现了抽象命令类
 * 拥有接收类的实例
 * 通过调用接受类的action，执行具体的业务操作
 */
public class AddCommand extends AbstractCommand{

    public void execute(int plus) {

        data.add(plus);

    }
}
