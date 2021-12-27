package com.example.spring.controllers;

import com.example.spring.models.Candidate;
import com.example.spring.models.User;
import com.example.spring.models.Vote;
import com.example.spring.models.Voting;
import com.example.spring.services.interfaces.ICandidateService;
import com.example.spring.services.interfaces.IVoteService;
import com.example.spring.services.interfaces.IVotingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/candidate/")
public class CandidateController {

    private final ICandidateService candidateService;
    private final IVotingService votingService;
    private final IVoteService voteService;

    public CandidateController(ICandidateService candidateService, IVotingService votingService, IVoteService voteService) {
        this.candidateService = candidateService;
        this.votingService = votingService;
        this.voteService = voteService;
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        Candidate candidate = candidateService.get(id);
        Voting voting = votingService.get(candidate.getVotingId());
        candidateService.delete(id);
        return "redirect:/voting/" + voting.getId();
    }

    @GetMapping("{candidateId}/vote")
    public String vote(Model model, HttpSession session, @PathVariable("candidateId") int id) {
        User user = (User) session.getAttribute("user");
        Vote vote = new Vote(id, user.getId());
        voteService.create(vote);
        System.out.println(vote);
        Voting voting = votingService.getByCandidate(id);
        return "redirect:/voting/" + voting.getId();
    }
}
