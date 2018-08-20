package com.pattern.command;

/**
 * 执行器
 * 拥有命令类的引用，不直接面向接收类
 * 通过调用命令类的execute方法，来间接操作接收类
 *
 * 此处
 *  可拥有命令类
 *  可拥有命令类的队列
 *  可通过组合模式拥有命令类的整体或局部
 */


public class CalculatorForm {

    public void executeAdd(AbstractCommand command, int data){
        command.execute(data);
    }

    public void executeMinus(AbstractCommand command, int data){
        command.execute(data);
    }
}
