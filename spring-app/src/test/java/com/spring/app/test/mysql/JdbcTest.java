package com.spring.app.test.mysql;

import com.spring.app.bean.User;
import com.spring.app.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.List;

/**
 * Created on 2020/5/29
 */
public class JdbcTest {

    @Test
    public void test01() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123123");
        System.out.println(connection);
        Statement statement = connection.createStatement();
        int update = statement.executeUpdate("insert into user1 (name) values ('tom') ");
        System.out.println(update);

        PreparedStatement prepareStatement = connection.prepareStatement("inert into user1(name,age)values(?,?)");

        prepareStatement.setString(1, "Jim");
        prepareStatement.setInt(2, 22);

        ResultSet resultSet = statement.executeQuery("select * from user1");
        if (resultSet != null) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                //索引从1开始
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(resultSet.getString(i) + "\t");
                }
            }
            System.out.println(metaData);
        }
        statement.close();
        connection.close();

    }


    @Test
    public void test02() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-datasource.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User(20, "张三");
        userService.save(user);
        List<User> list = userService.list();
        list.stream().forEach(System.out::println);


    }


}
