package com.spring.app.http.impl;

import com.spring.app.http.HttpInvokerServerTest;

/**
 * Created on 2020/5/31
 */
public class HttpInvokerServerTestImpl implements HttpInvokerServerTest {

    @Override
    public String getPo(String str) {
        return "test" + str;
    }
}
