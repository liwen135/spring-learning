package com.spring.app.test.rmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created on 2020/5/31
 */
public class RMIProvider {

    public static void main(String[] args) throws IOException {

        new ClassPathXmlApplicationContext("spring-rmi-provider-test.xml");
    }
}
