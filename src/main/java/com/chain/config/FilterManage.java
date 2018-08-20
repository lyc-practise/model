package com.chain.config;

import com.chain.interf.Filter;
import com.chain.interf.FilterChain;
import com.chain.model.EncodeFilter;
import com.chain.model.LogFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterManage {

    private static List<Filter> filterList = new ArrayList<Filter>();


    static{
        System.out.println("init filterConfig");
        filterList.add(new LogFilter());
        filterList.add(new EncodeFilter());
    }


    public FilterChain getFilterChain(){
        return new FilterChainImpl(filterList) ;
    }

}
