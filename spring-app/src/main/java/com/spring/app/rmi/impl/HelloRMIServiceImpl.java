package com.spring.app.rmi.impl;

import com.spring.app.rmi.HelloRMIService;

/**
 * Created on 2020/5/31
 */
public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int add(int a, int b) {
        System.out.println("HelloRMIServiceImpl invoke....");
        return a + b;
    }
}
