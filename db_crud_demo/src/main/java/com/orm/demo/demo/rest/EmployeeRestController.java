package com.orm.demo.demo.rest;

import com.orm.demo.demo.dao.EmployeeDAO;
import com.orm.demo.demo.dao.EmployeeDAOJpaImpl;
import com.orm.demo.demo.entity.Employee;
import com.orm.demo.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
