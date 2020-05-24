package com.spring.demo.service.impl;

import com.spring.demo.bean.Employee;
import com.spring.demo.dao.CityDao;
import com.spring.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private Employee employee;

    @Override
    public void deal() {

    }
}
