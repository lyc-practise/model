package com.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象集合 ， 未对遍历器类开放内部
 */
public abstract class AbstractAggregate {

    protected List<Object> list = new ArrayList<Object>();


    public AbstractAggregate(List<Object> list){
        this.list = list;
    }

    public void add(Object object){
        list.add(object);
    }

    public void remove(Object object){
        list.remove(object);
    }

    public List<Object> getList(){
        return list;
    }

    public abstract AbstractIterator createIterator();
}


