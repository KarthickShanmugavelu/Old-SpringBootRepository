package com.orm.demo.demo.service;

import com.orm.demo.demo.dao.EmployeeDAO;
import com.orm.demo.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
