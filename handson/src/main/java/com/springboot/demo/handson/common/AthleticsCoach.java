package com.springboot.demo.handson.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("theAthleticsCoach")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AthleticsCoach implements Coach{
    public AthleticsCoach() {
        System.out.println("Inside constructor of "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do some swimming for refreshment";
    }
}
