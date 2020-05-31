package com.spring.app.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/5/31
 */
public class HelloWorldLastModifiedCacheController extends AbstractController implements LastModified {

    private long lastModified;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @Override
    public long getLastModified(HttpServletRequest request) {
        if (lastModified == 0L) {
            lastModified = System.currentTimeMillis();
        }
        return lastModified;
    }
}
