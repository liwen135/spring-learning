package com.spring.app.test.http;

import com.spring.app.http.HttpInvokerServerTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2020/5/31
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("client.xml");
        HttpInvokerServerTest httpInvokerServerTest = (HttpInvokerServerTest) context.getBean("remoteService");
        System.out.println(httpInvokerServerTest.getPo("ddd"));
    }
}
