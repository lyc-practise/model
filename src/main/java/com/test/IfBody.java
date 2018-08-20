package com.test;


/**
 * 总结：
 *  如果 if/else 不加代码结构的开始结束符{} ，那么就只执行一行。剩下的当成其他统一代码，不再区分if/else
 */
public class IfBody {


    private static void ifLine(){
        int a = 2;
        if (a > 1) System.out.println("a > 2");
        System.out.println("other");
    }


    private static void ifElseLine(){
        int a = 3;
        if(a > 2) System.out.println("a > 2");
        else System.out.println("a <= 2");
        System.out.println("other");
    }

    private static void ifElseLine2(){
        int a = 1;
        if(a > 2)
            System.out.println("a > 2");
//            System.out.println("a>2 ");  // 如果加上这行，else代码会报异常
        else System.out.println("a <= 2");
        System.out.println("other");
    }


    private static void ifNoLine(){
        int a = 3;
        if(a > 2)
            System.out.println("a > 2");
        System.out.println("other");
    }
    public static void main(String[] args) {

        System.out.println("----------ifLine------------");

        ifLine();

        System.out.println("-----------ifNoLine------------");

        ifNoLine();

        System.out.println("-----------ifElseLine------------");

        ifElseLine();

        System.out.println("----------ifElseLine2-------------");

        ifElseLine2();

    }
}
