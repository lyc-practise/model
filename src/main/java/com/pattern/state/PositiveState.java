package com.pattern.state;

/**
 * 具体的实现类 -- 正数的处理
 */
public class PositiveState extends State {
    @Override
    public void handle(Context context, int plus) {
        context.setValue(context.getValue() + plus);
        System.out.println("positiveState handle ...");
    }
}
