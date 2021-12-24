package com.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/team")
public class TeamController {

    @GetMapping("/huk")
    @ResponseBody
    public String getDavydHukPage() {
        return "Davyd Huk";
    }

    @GetMapping("/derachyts")
    @ResponseBody
    public String getDerachytsVitaliiPage() {
        return "Derachyts Vitalii";
    }
}
