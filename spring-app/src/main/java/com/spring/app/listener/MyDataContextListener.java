package com.spring.app.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created on 2020/5/30
 */
public class MyDataContextListener implements ServletContextListener {

    private ServletContext servletContext;

    public MyDataContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.servletContext = null;
    }
}
