package com.utils;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 数据校验方法
 * 但是需要指定异常类，且异常类需要支持 String 构造方法
 * @param <T>
 */
public class Validator<T> {

    private T t;
    private Class<? extends Exception> e;

    private Validator(T t){
        this.t = t;
    }

    public static <T> Validator<T> of(T t){
        return new Validator<T>(t);
    }

    public Validator<T> exception(Class<? extends Exception> e){
        this.e = e;
        return this;
    }

    public Validator<T> validate(Predicate<T> condition, String message) throws Exception {
        if(!condition.test(t)){
            throw e.getConstructor(String.class).newInstance(message);
        }
        return this;
    }

    public <V> Validator<T> validate(Function<T, V> function, Predicate<V> condition, String message) throws Exception {
        return validate(function.andThen(condition::test)::apply, message);
    }

}
