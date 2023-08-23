package com.springboot.demo.MySpringBootApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeRestController {

    @Value("${team.name}")
    private String teamName;

    @Value("${team.contact}")
    private String teamContact;
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/getDailyQuotes")
    public String sayQuotes(){
        return "This day is an awesome and fabulous day!";
    }

    @GetMapping("/testCustomProperty")
    public String testCustomProperty(){
        return "The team name is "+teamName+" and the team contact is "+teamContact;
    }
}
