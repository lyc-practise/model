package com.utils;

import java.util.*;

public class CollectionUtils {

    public static boolean isEmpty(Collection colls){
        return colls == null || colls.isEmpty();
    }


    public static <T> List<T> orElse(List<T> colls){
        if(isEmpty(colls)) return new ArrayList<T>();
        return colls;
    }

    public static <T> Set<T> orElse(Set<T> colls){
        if(isEmpty(colls)) return new HashSet<T>();
        return colls;
    }

    public static <K, V> Map<K,V> orElse(Map<K,V> colls){
        if(colls == null || colls.isEmpty() ) return new HashMap<K, V>();
        return colls;
    }

}
