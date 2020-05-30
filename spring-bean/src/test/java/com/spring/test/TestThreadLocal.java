package com.spring.test;

import com.spring.demo.bean.Employee;
import org.junit.Test;

import java.io.IOException;

/**
 * Created on 2020/5/26
 */
public class TestThreadLocal {

    private ThreadLocal<Employee> threadLocal = new ThreadLocal<Employee>();


    @Test
    public void test02() throws IOException, InterruptedException {
        Employee employee = new Employee();
        employee.setName("tom");
        threadLocal.set(employee);
        new Thread() {
            @Override
            public void run() {
                Employee o = threadLocal.get();
                System.out.println("sub thread1:" + Thread.currentThread().getId() + "=" + o);
                threadLocal.remove();
                System.out.println("sub thread2:" + Thread.currentThread().getId() + "=" + threadLocal.get());
                Employee employee = new Employee();
                employee.setName("jim");
                threadLocal.set(employee);
                System.out.println("sub thread3:" + Thread.currentThread().getId() + "=" + threadLocal.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocal.remove();
                System.out.println("sub thread4:" + Thread.currentThread().getId() + "=" + threadLocal.get());
            }
        }.start();

        System.out.println("main thread1:" + Thread.currentThread().getId() + "=" + threadLocal.get());
        threadLocal.remove();
        System.out.println("main thread2:" + Thread.currentThread().getId() + "=" + threadLocal.get());
        Thread.sleep(2000);
    }

    @Test
    public void test01() {
        Employee o = threadLocal.get();
        System.out.println(o);
        Employee employee = new Employee();
        employee.setName("tom");
        threadLocal.set(employee);
        System.out.println(threadLocal.get());

        try {
            System.out.println(threadLocal.get());
            threadLocal.remove();
            int num = 10 / 0;

        } finally {
            if (threadLocal.get() != null) {
                threadLocal.remove();
                System.out.println(threadLocal.get());
            } else {
                System.out.println(11111111);
            }


        }


        System.out.println(threadLocal.get());

    }


}
