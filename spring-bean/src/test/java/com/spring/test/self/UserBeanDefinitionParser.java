package com.spring.test.self;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        ///todo
    }
}
