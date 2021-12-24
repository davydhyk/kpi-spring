package com.example.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Second implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Second");
    }
}
