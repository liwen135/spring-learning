package com.spring.app.service;

import com.spring.app.bean.User;

import java.util.List;

/**
 * Created on 2020/5/30
 */
public interface UserService {

    void save(User user);

    List<User> list();

}
