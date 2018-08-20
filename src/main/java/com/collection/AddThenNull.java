package com.collection;

import java.util.ArrayList;
import java.util.List;

public class AddThenNull {

    public static void main(String[] args) {

        String a = "abc";
        String b = "abc";

        System.out.println(a == b);

        String c = new String("abc").intern();

        c = c.intern();
        System.out.println(a == c);

        c.intern();
        System.out.println(a == c);

        String d = new String("abc").intern();

        System.out.println(a == d);

    }

}
