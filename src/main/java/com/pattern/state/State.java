package com.pattern.state;

/**
 * 状态抽象类
 * 此处实现的状态变化是在状态中控制，因控制方式一致，固提取到抽象类中完成
 * 此处用了callback模式-参考模板方法模式，开放业务方法让具体实现类实现。在业务类操作完后回调checkState()方法。
 */
public abstract class State {

    abstract void handle(Context context, int plus);

    public void handleRequest(Context context, int plus){
        handle(context, plus);
        checkState(context);
    }

    void checkState(Context context){
        if(context.getValue() >= 0 ){
            context.setState(new PositiveState());
        }else{
            context.setState(new NegativeState());
        }
    }
}
