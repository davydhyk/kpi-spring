package com.example.spring.controllers.rest;

import com.example.spring.models.Pageable;
import com.example.spring.models.Voting;
import com.example.spring.services.interfaces.IVotingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voting/")
public class VotingRestController {

    private final IVotingService votingService;

    public VotingRestController(IVotingService votingService) {
        this.votingService = votingService;
    }

    @GetMapping
    public List<Voting> getAll() {
        return votingService.getAll();
    }

    @GetMapping("paged")
    public List<Voting> getAllPaged(Pageable pageable) {
        return votingService.getAllPaged(pageable);
    }

    @GetMapping("{id}")
    public Voting read(@PathVariable int id) {
        return votingService.get(id);
    }

    @PostMapping
    public Voting create(@ModelAttribute Voting voting) {
        votingService.create(voting);
        return votingService.get(voting.getId());
    }

    @PutMapping
    public boolean update(@ModelAttribute Voting voting) {
        votingService.update(voting);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        votingService.delete(id);
        return true;
    }
}
