package com.orm.demo.demo.dao;

import com.orm.demo.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
