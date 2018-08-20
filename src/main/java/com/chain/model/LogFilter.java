package com.chain.model;

import com.chain.interf.FilterChain;
import com.chain.interf.Filter;

public class LogFilter implements Filter {
    public void execute(Request request, Response response, FilterChain filterChain) {
        System.out.println("log filter do before");
        filterChain.doChain(request, response, filterChain);
        System.out.println("log filter do after");
    }
}
