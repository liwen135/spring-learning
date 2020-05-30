package com.spring.app.test.mybatis;

import com.spring.app.bean.User;
import com.spring.app.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2020/5/30
 */
public class MybatisWithSpringTest {
    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring-datasource.xml");
        UserDao mapper = act.getBean(UserDao.class);
        User user = new User(23, "mybatis");
        User user1 = mapper.select(user);
        System.out.println(user1);
    }

}
