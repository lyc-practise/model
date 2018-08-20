package com.pattern.iterator;

import java.util.List;

/**
 * 只拥有集合类的引用，不知道集合类的内在实现细节。
 */
public class ConcreteIterator implements AbstractIterator {


    private AbstractAggregate aggregate;
    private List<Object> aggregateList ;
    private int cursorNext;
    private int cursorPrevious;

    public ConcreteIterator(AbstractAggregate aggregate){
        this.aggregate = aggregate;
        this.aggregateList = aggregate.getList();
        cursorPrevious = aggregateList.size();
        cursorNext = -1;
    }

    public AbstractAggregate getAggregate() {
        return aggregate;
    }

    public void setAggregate(AbstractAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregateList.get(0);
    }

    @Override
    public Object last() {
        return aggregateList.get(aggregateList.size()-1);
    }

    @Override
    public Object previous() {
        if(cursorPrevious > -1) return aggregateList.get(cursorPrevious);
        return null;
    }

    @Override
    public Object next() {
        if(cursorNext < aggregateList.size()) return aggregateList.get(cursorNext);
        return null;
    }

    @Override
    public boolean hasNext() {
        cursorNext ++ ;
        return cursorNext < aggregateList.size();
    }

    @Override
    public boolean hasPrevious() {
        cursorPrevious --;
        return cursorPrevious > -1;
    }

    @Override
    public Object currentItem() {
        return null;
    }
}
