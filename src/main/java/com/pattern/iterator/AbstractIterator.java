package com.pattern.iterator;

public interface AbstractIterator {

    Object first();
    Object last();
    Object previous();  // 上一个
    Object next();      // 下一个
    boolean hasNext();  // 是否还有下一个
    boolean hasPrevious();  // 是否还有上一个
    Object currentItem();

}
