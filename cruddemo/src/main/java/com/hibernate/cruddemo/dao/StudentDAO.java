package com.hibernate.cruddemo.dao;

import com.hibernate.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student find(int id);
    List<Student> findAll();
    List<Student> findStudentByLastName(String lastName);
    void update(Student student);
    void updateStudentUsingQuery();
    void deleteStudent(int id);
    int deleteAll();
}
