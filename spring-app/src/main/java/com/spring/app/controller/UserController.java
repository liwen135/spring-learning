package com.spring.app.controller;

import com.spring.app.bean.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/5/30
 */

public class UserController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> list = new ArrayList<>();
        User user = new User(10, "张三");
        User user1 = new User(11, "李四");
        list.add(user);
        list.add(user1);
        return new ModelAndView("userlist", "users", list);
    }
}
