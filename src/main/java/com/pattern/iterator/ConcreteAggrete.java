package com.pattern.iterator;

import java.util.List;

/**
 * 集合
 */
public class ConcreteAggrete extends AbstractAggregate {

    public ConcreteAggrete(List<Object> list) {
        super(list);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ConcreteIterator(this);
    }

}

