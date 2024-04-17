package ru.gb.issue_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ar.TimerAspect;

@SpringBootApplication
public class IssueServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IssueServiceApplication.class, args);
    }

// Добавление бина напрямую => без стартера
//    @Bean
//    TimerAspect timerAspect() {
//        return new TimerAspect();
//    }
}
