package com.chain.interf;

import com.chain.model.Request;
import com.chain.model.Response;

public interface FilterChain {

    public void doChain(Request request, Response response, FilterChain filterChain);
}
