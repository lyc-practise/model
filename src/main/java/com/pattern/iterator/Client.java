package com.pattern.iterator;

import java.util.ArrayList;

/**
 * 迭代器模式
 */

class Model{

    private static int num = 1;
    private String name;
    public Model(){
        this.name = "liu" + (num++);
    }
    public String toString(){
        return name;
    }

}


public class Client {

    private static void add(AbstractAggregate aggregate, int num){
        for(int i = 0 ; i < num; i++){
            aggregate.add(new Model());
        }
    }

    public static void main(String[] args) {
        AbstractAggregate aggregate = new ConcreteAggrete(new ArrayList<>());
        add(aggregate, 5);


        // 顺序遍历
        System.out.println("顺序遍历");
        AbstractIterator iterator = aggregate.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 逆向遍历
        System.out.println("逆向遍历");
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

    }



}
