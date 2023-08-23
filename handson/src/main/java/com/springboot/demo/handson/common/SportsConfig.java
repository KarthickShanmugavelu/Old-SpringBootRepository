package com.springboot.demo.handson.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean(name="basketBallCoach")
    public Coach basketBallCoach(){
        return new BasketballCoach();
    }
}
