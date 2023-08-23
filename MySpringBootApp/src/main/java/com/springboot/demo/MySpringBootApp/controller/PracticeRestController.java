package com.springboot.demo.MySpringBootApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
