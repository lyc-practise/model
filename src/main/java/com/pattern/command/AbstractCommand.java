package com.pattern.command;

/**
 * 命令抽象类
 * 定义了命令执行的操作
 * 实际不会拥有接收类，只是次数实例这么写
 * 具体命令类可能会有不同的接收类。
 */
public abstract class AbstractCommand {

    protected Data data;

    public abstract void execute(int plus);

    public void setData(Data data){
        this.data = data;
    }

}
