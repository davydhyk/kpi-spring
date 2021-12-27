package com.example.spring.controllers.rest;

import com.example.spring.models.Vote;
import com.example.spring.services.interfaces.IVoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vote/")
public class VoteRestController {

    private final IVoteService voteService;

    public VoteRestController(IVoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public List<Vote> getAll() {
        return voteService.getAll();
    }

    @GetMapping("{id}")
    public Vote read(@PathVariable int id) {
        return voteService.get(id);
    }

    @PostMapping
    public Vote create(@ModelAttribute Vote vote) {
        voteService.create(vote);
        return voteService.get(vote.getId());
    }

    @PutMapping
    public boolean update(@ModelAttribute Vote vote) {
        voteService.update(vote);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        voteService.delete(id);
        return true;
    }
}
