package com.spring.app.test.rmi;

import com.spring.app.rmi.HelloRMIService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2020/5/31
 */
public class RMIClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-rmi-client-test.xml");
        HelloRMIService myClient = context.getBean("myClient", HelloRMIService.class);
        System.out.println(myClient.add(1, 2));
    }
}
