package com.example.spring.controllers.rest;

import com.example.spring.models.Candidate;
import com.example.spring.services.interfaces.ICandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate/")
public class CandidateRestController {

    private final ICandidateService candidateService;

    public CandidateRestController(ICandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getAll() {
        return candidateService.getAll();
    }

    @GetMapping("{id}")
    public Candidate read(@PathVariable int id) {
        return candidateService.get(id);
    }

    @PostMapping
    public Candidate create(@ModelAttribute Candidate candidate) {
        candidateService.create(candidate);
        return candidateService.get(candidate.getId());
    }

    @PutMapping
    public boolean update(@ModelAttribute Candidate candidate) {
        candidateService.update(candidate);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        candidateService.delete(id);
        return true;
    }
}
