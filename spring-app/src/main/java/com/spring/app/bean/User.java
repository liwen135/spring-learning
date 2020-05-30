package com.spring.app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on 2020/5/30
 */
@Data
public class User {

    private Long id;

    private Integer age;

    private  String name;

    public User() {
    }

    public User(Long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}
