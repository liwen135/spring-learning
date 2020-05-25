package com.spring.test.self;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNameHandlerSupport extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
