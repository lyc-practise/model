package com.pattern.composite;

import java.util.List;

/**
 * 抽象出来的组件对象
 */
public interface Component {

    void add(Component component);
    void remove(Component component);
    void operate();
    List<Component> getChild();
}
