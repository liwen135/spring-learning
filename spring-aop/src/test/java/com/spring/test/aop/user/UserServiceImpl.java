package com.spring.test.aop.user;

/**
 * Created on 2020/5/29
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("=================add======================");
    }
}
