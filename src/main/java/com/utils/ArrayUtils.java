package com.utils;

import java.lang.reflect.Array;
import java.util.function.Function;

public class ArrayUtils {

    /**
     转换数组的类型，例如从 String[] 转换为 Integer[]
     经测试，不用判断是否是 Object[].clss ， Object对象的处理也可以通过 Array.newInstance() 来进行
     newType.getComponentType() 返回的是 R.class
     **/

    public static <T,R> R[] parseArrayType(T[] tArray, Function<T, R> function, Class<? extends R[]> newType){
        if(tArray == null) return null;
        R[] rArray = ((Object)newType == (Object)Object[].class)
                ? (R[]) new Object[tArray.length]
                : (R[]) Array.newInstance(newType.getComponentType(), tArray.length);

        for(int i=0;i<tArray.length;i++){
            rArray[i] = function.apply(tArray[i]);
        }

        return rArray;
    }


    /**
        见上例
     **/
    public static <T> T[] appendArray(T[] array, T t){

        T[] tarray = (T[])Array.newInstance(t.getClass(), array == null ? 1 : array.length + 1);
        tarray[tarray.length-1] = t;
        if(array == null) return tarray;
        System.arraycopy(array, 0, tarray, 0, array.length);
        return tarray;
    }
}
