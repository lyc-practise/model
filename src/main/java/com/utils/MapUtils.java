package com.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lc on 11/3/2016.
 * Copyright by mofanghr
 */
public class MapUtils {

    public static Map hashMapOf(Object... o) {
        Map map = new HashMap();
        if (null == o || o.length <= 0) {
            return map;
        }

        for (int i = 0; i < o.length - 1; i += 2) {
            map.put(o[i], o[i + 1]);
        }
        return map;
    }

    public static boolean isEmpty(Map map){
        return map == null || map.size() == 0;
    }
}
