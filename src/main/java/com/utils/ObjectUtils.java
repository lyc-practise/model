package com.utils;

import java.beans.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 对字符串类型的值
 * 增加了对基础类型的兼容。
 * 增加了对数组类型的兼容。
 */
public class ObjectUtils {

    /**
     * 将Map类型转换成具体的bean，兼容数组转换和基础类型的转换。
     * @param type
     * @param map
     * @param <T>
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static <T> T convertMap(Class<T> type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);
                if(value==null||"".equals(value)){
                    continue;
                }
                Object[] args = new Object[]{parseType(descriptor.getPropertyType(), value)};
                try{
                    descriptor.getWriteMethod().invoke(obj, args);
                }catch (Exception e){
                    System.out.println(String.format("convert value [%s] to property [%s] fail !", value, propertyName));
                }
            }
        }
        return (T)obj;
    }

    public static <T> T  parseType(Class<T> ct, Object value){
        if(ct.isArray()){  // 处理数据对象
            if(value.getClass().isArray()){
                Object newArray = Array.newInstance(ct.getComponentType(), Array.getLength(value));
                for(int i = 0 ;i < Array.getLength(value); i++){
                    Array.set(newArray, i, parseType(ct.getComponentType(), Array.get(value, i)));
                }
                return (T)newArray;
            }else{
                System.out.println("need array ,but found object!");
                return null;
            }
        }else if(ct.isPrimitive()){  // 处理原始数据类型
            return parsePrimitiveType(ct, value);
        }else if(ct.isInstance(value)){   // 可以强制转换
            return (T)value;
        }else{
            return null;
        }

    }
    public static <T> T parsePrimitiveType(Class<T> pri, Object value){
        if(!pri.isPrimitive() || value == null) return null;
        if(pri.isAssignableFrom(boolean.class)) return (T)Boolean.valueOf(value.toString());
        if(pri.isAssignableFrom(char.class)) return (T)value.toString();
        if(pri.isAssignableFrom(byte.class)) return (T)Byte.valueOf(value.toString());
        if(pri.isAssignableFrom(int.class)) return (T)Integer.valueOf(value.toString());
        if(pri.isAssignableFrom(float.class)) return (T)Float.valueOf(value.toString());
        if(pri.isAssignableFrom(double.class)) return (T)Double.valueOf(value.toString());
        if(pri.isAssignableFrom(long.class)) return (T)Long.valueOf(value.toString());
        if(pri.isAssignableFrom(short.class)) return (T)Short.valueOf(value.toString());
        return null;
    }

}
