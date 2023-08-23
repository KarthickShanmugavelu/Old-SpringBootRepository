package com.springboot.demo.handson.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy - For Lazy initialization
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Inside constructor of "+ getClass().getSimpleName());
    }

    @PostConstruct
    public void customInitMethod(){
        System.out.println("Inside Custom init Method of "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "To start with, do some warm up";
    }

    @PreDestroy
    public void customDestroyMethod(){
        System.out.println("Inside Custom destroy Method of "+ getClass().getSimpleName());
    }
}
