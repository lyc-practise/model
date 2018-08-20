package com.pattern.composite;

import java.util.List;

/**
 * 叶子节点
 */
public class Leaf implements Component {

    @Override
    public void add(Component component) {
        System.out.println("do nothing");
    }

    @Override
    public void remove(Component component) {
        System.out.println("do nothing");
    }

    @Override
    public void operate() {
        System.out.println("left do");
    }

    @Override
    public List<Component> getChild() {
        return null;
    }
}
