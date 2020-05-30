package com.spring.test.aop.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created on 2020/5/29
 */
public class EnhancerDemo {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("==before==");
                Object res = methodProxy.invokeSuper(o, args);
                System.out.println("==after==");
                return res;
            }
        });

        EnhancerDemo demo = (EnhancerDemo) enhancer.create();
        demo.test();
        System.out.println(demo);

    }

    public void test() {
        System.out.println("EnhancerDemo test");
    }
}
