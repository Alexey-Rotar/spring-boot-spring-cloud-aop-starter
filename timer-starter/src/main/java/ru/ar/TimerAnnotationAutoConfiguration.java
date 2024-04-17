package ru.ar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class TimerAnnotationAutoConfiguration {

    @Bean
    TimerAspect timerAspect() {
        return new TimerAspect();
    }
}
