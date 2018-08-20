package com.pattern.state;

/**
 * 环境类
 * 环境类拥有状态的引用
 * 拥有状态变化的标志 value
 * 有业务方法，不过业务方法实际是由具体的状态实现类来实现的。
 */
public class Context {

    private State state;
    private int value;   // 因value而映射不同的状态，即导致状态变更的因子

    public void setState(State state) {
        this.state = state;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void request(int plus){
        if(state != null){
            state.handleRequest(this, plus);
        }
    }
}
