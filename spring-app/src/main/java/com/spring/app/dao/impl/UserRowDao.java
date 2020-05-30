package com.spring.app.dao.impl;


import com.spring.app.bean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 2020/5/29
 */
public class UserRowDao implements RowMapper {

    @Override
    public Object mapRow(ResultSet set, int index) throws SQLException {
        Long id = set.getLong("id");
        String name = set.getString("name");
        int age = set.getInt("age");
        User user = new User(id, age, name);

        return user;
    }
}
