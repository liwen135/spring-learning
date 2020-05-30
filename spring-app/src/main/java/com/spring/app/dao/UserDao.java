package com.spring.app.dao;

import com.spring.app.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020/5/30
 */
public interface UserDao {

    User selectById(Long id);


    Integer insert(User user);

    Integer batchInsert(List<User> userList);

    Integer update(User user);

    Integer deleteById(Long id);


    User select(User user);

    List<User> selectByName(String name);

    List<User> selectByIds(List<Integer> ids);

    List<User> selectByNames(@Param("names") List<String> names);

    List<User> selectByMap(Map<String, String> map);

    //    Available parameters are [0, 1, param1, param2]
//    User selectByEmailAndName(String name, String email);
    User selectByEmailAndName(@Param("userName") String name, @Param("email") String email);

    List<User> queryUser(User user);

    Long updateByIDs(User user);


    Integer count();
}
