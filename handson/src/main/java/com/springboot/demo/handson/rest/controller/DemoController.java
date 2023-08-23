package com.springboot.demo.handson.rest.controller;

import com.springboot.demo.handson.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Field injection
    /*@Autowired
    @Qualifier("theAthleticsCoach") //- using qualifier*/
    private Coach coach;

    private Coach coach2;

    @Autowired
    public DemoController(@Qualifier("basketBallCoach")Coach coach,@Qualifier("cricketCoach")Coach coach2) {
        System.out.println("Inside constructor of "+ getClass().getSimpleName());
        this.coach = coach;
        this.coach2=coach2;
    }

  /* Setter Injection
   @Autowired
    public void setCoach(Coach coach){
        this.coach=coach;
    }*/

    @GetMapping("/getDailyWorkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

    @GetMapping("/checkIfSingleton")
    private boolean checkIfSingleton(){
        return coach==coach2;
    }
}
