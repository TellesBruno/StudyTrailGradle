package com.tellesbruno.subproject.gradle.config;

import com.tellesbruno.subproject.gradle.examples.MySampleClass;
import com.tellesbruno.subproject.gradle.examples.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfig {
    @Bean
    public MySampleClass mySampleClass() {
        return new MySampleClass();
    }

    @Bean
    public Runner runner() {
        return new Runner(new MySampleClass());
    }
}
