package com.chain.config;

import com.chain.interf.Filter;
import com.chain.interf.FilterChain;
import com.chain.model.Request;
import com.chain.model.Response;

import java.util.ArrayList;
import java.util.List;

class FilterChainImpl implements FilterChain {

    private List<Filter> filterList = new ArrayList<Filter>();
    private int currentIndex = 0;

    public FilterChainImpl(List<Filter> filterList){
        this.filterList = filterList;
    }


    public void doChain(Request request, Response response, FilterChain filterChain) {

        Filter filter = filterList.size() >= currentIndex + 1 ? filterList.get(currentIndex) : null;
        if(filter == null){
            System.out.println(" execute action !");
        }else{
            currentIndex ++;
            filter.execute(request, response, filterChain);
        }
    }
}
