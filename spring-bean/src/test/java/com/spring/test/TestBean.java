package com.spring.test;

import com.spring.demo.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.stream.Stream;

public class TestBean {
    ApplicationContext act = null;

    @Before
    public void init() {
        act = new ClassPathXmlApplicationContext("classpath:spring-config-test.xml");
    }

    @Test
    public void look() {
        System.out.println(act);
    }

    /**
     * No qualifying bean of type 'com.spring.demo.bean.Employee' available: expected single matching bean but found 2:
     * com.spring.demo.bean.Employee#0,com.spring.demo.bean.Employee#1
     */
    @Test
    public void getBean() {
        Object bean = act.getBean(Employee.class);
        System.out.println(bean);
    }

    @Test
    public void getBeanByid() {
        Object bean = act.getBean("emp01");
        System.out.println(bean);
    }

    @Test
    public void getCity() {
        Object bean = act.getBean("city");
        System.out.println(bean);
    }

    @Test
    public void getAllBean() {
        Stream<String> definitionNames = Stream.of(act.getBeanDefinitionNames());
        definitionNames.forEach(e -> System.out.println(e));
    }

    @Test
    public void test() {
        AutowireCapableBeanFactory beanFactory = act.getAutowireCapableBeanFactory();
        Employee bean = beanFactory.createBean(Employee.class);
        System.out.println(bean);
        Resource r =   new ClassPathResource("");
    }



}
