package com.example.spring.controllers;

import com.example.spring.models.User;
import com.example.spring.services.interfaces.IVotingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    private final IVotingService votingService;

    public HomeController(IVotingService votingService) {
        this.votingService = votingService;
        System.out.println(votingService.getAll());
    }

    @GetMapping("")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("votings", votingService.getByUser(user.getId()));
        return "index";
    }
}
