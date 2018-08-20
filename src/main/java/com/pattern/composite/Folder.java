package com.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 非叶子节点
 */
public class Folder implements Component{

    private List<Component> childs = new ArrayList<>();
    @Override
    public void add(Component component) {
        childs.add(component);
    }

    @Override
    public void remove(Component component) {
        childs.remove(component);
    }

    @Override
    public void operate() {
        for(Component component : childs){
            component.operate();
        }
    }

    @Override
    public List<Component> getChild() {
        return childs;
    }
}
