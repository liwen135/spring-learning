package com.spring.app.service.impl;

import com.spring.app.bean.User;
import com.spring.app.dao.impl.UserRowDao;
import com.spring.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * Created on 2020/5/30
 */
@Slf4j
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        int update = jdbcTemplate.update("insert into user1(name,age)values(?,?)", new Object[]{user.getName(), user.getAge()}, new int[]{Types.VARBINARY, Types.INTEGER});
        log.info("UPDATE ROWS:{}", update);
    }


    @Override
    public List<User> list() {
        List list = jdbcTemplate.query("select * from user1", new UserRowDao());

        return list;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
