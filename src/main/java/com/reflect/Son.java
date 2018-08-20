package com.reflect;


class Father<T>{

    private String fatherPrivateParam;
    protected String fatherProtectedParam;
    String fatherDefaultParam;
    public String fatherPublicParams;

    private void fatherPrivateFun(){}

    void fatherDefaultFun(){}

    protected void fatherProtectedFun(){}

    public void fatherPublicFun(){}

    public T bridge(T t){
        return t;
    }
}

public class Son extends Father<String>{


    private String sonPrivateParam;
    protected String sonProtectedParam;
    String sonDefaultParam;
    public String sonPublicParams;

    private void sonPrivateFun(){}

    void sonDefaultFun(){}

    protected void sonProtectedFun(){}

    public void sonPublicFun(){}

}
