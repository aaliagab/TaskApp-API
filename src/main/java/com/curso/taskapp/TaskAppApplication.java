package com.curso.taskapp;

import org.springdoc.core.SpringDocUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskAppApplication.class, args);
    }
    static {
        SpringDocUtils.getConfig().addAnnotationsToIgnore(
                org.springframework.beans.factory.annotation.Autowired.class,
                javax.annotation.Resource.class
        );
    }
}
