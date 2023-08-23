package com.springboot.demo.handson.common;

public class BasketballCoach implements Coach{
    public BasketballCoach() {
        System.out.println("Inside constructor of "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice dribbling for 15 minutes";
    }
}
