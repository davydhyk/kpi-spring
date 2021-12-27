package com.example.spring;

import com.example.spring.models.Candidate;
import com.example.spring.models.User;
import com.example.spring.models.Vote;
import com.example.spring.models.Voting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User("192.168.1.2");
//        System.out.println(user);
//        Voting voting = new Voting("Title", new Date(), new Date(), user.getId());
//        System.out.println(voting);
//        Candidate candidate = new Candidate("Name", "Description", voting.getId());
//        System.out.println(candidate);
//        Vote vote = new Vote(candidate.getId(), user.getId());
//        System.out.println(vote);
    }

}
