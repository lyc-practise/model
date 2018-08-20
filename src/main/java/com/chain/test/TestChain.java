package com.chain.test;

import com.chain.config.FilterManage;
import com.chain.interf.FilterChain;
import com.chain.model.Request;
import com.chain.model.Response;

public class TestChain {


    public static void main(String[] args) {

        FilterManage filterManage = new FilterManage();
        FilterChain filterChain = filterManage.getFilterChain();
        filterChain.doChain(new Request(), new Response(), filterChain);




    }
}
