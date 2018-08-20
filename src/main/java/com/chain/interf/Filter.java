package com.chain.interf;

import com.chain.model.Request;
import com.chain.model.Response;

public interface Filter {


    public void execute(Request request, Response response, FilterChain filterChain);
}
