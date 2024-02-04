package com.code.rest.api.controller;

import com.code.rest.api.entity.Student;
import com.code.rest.api.entity.StudentErrorResponse;
import com.code.rest.api.entity.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> studentList;

    @PostConstruct
    public void loadData() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("Karthick", "Shanmugavelu"));
        studentList.add(new Student("Naveen", "Kumar"));
        studentList.add(new Student("Deepak", "Anand"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return this.studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId>studentList.size() || studentId<0){
            throw new StudentNotFoundException("Student id '"+studentId+"' not found");
        }
        return this.studentList.get(studentId);
    }

}
