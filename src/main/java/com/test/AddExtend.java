package com.test;

import java.util.ArrayList;
import java.util.List;

class Father{
    protected static List<Father> list = new ArrayList<Father>();
    public Father(){
        list.add(this);
        }
}


class Son1 extends Father{

}
class Son2 extends Father{

}

public class AddExtend {

    public static void main(String[] args) {
        Father father = new Son1();
        Father father1 = new Son2();

        System.out.println(Father.list.size());
        System.out.println(Father.list.get(0));
    }
}
