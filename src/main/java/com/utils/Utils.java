package com.utils;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class Utils {

    public static Date parseDate(String date){
        return parse(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay());
    }

    public static Date parseDateTime(String date){
        return parse(LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    private static Date parse(LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static <T> boolean isEmpty(T t){
        return t==null
                || ((t instanceof String) && StringUtils.isEmpty(t))
                || ((t instanceof Collection) && ((Collection) t).isEmpty())
                || ((t instanceof Map) && ((Map)t).isEmpty() );
    }

    public static <T> T orElse(T ... array){
        for(T tmp : array){
            if(tmp != null) return tmp;
        }
        return null;
    }

    public static <T> T emptyOrElse(T ... array){
        for(T tmp : array){
            if(!isEmpty(tmp)) return tmp;
        }
        return orElse(array);
    }


}
