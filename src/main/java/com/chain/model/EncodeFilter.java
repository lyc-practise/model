package com.chain.model;

import com.chain.interf.FilterChain;
import com.chain.interf.Filter;

public class EncodeFilter implements Filter {
    public void execute(Request request, Response response, FilterChain filterChain) {


        System.out.println("encode filter do before");
        filterChain.doChain(request, response, filterChain);
        System.out.println("encode filter do after");

    }
}
