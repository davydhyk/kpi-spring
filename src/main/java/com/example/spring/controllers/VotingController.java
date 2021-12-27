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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/voting/")
public class VotingController {

    private final IVotingService votingService;
    private final ICandidateService candidateService;
    private final IVoteService voteService;

    public VotingController(IVotingService votingService, ICandidateService candidateService, IVoteService voteService) {
        this.votingService = votingService;
        this.candidateService = candidateService;
        this.voteService = voteService;
    }

    @GetMapping("{id}")
    public String createPage(Model model, HttpSession session, @PathVariable int id) {
        User user = (User) session.getAttribute("user");
        Voting voting = votingService.getWithCandidates(id);
        model.addAttribute("voting", voting);
        Vote vote = voteService.getByVotingAndUser(voting.getId(), user.getId());
        model.addAttribute("vote", vote);
        boolean isVoted = vote != null;
        model.addAttribute("isVoted", isVoted);
        return "voting";
    }

    @GetMapping("create")
    public String createPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Voting voting = new Voting();
        voting.setUserId(user.getId());
        model.addAttribute("voting", voting);
        return "voting-create";
    }

    @PostMapping("create")
    public String create(Model model, @ModelAttribute Voting voting) {
        votingService.create(voting);
        System.out.println(voting);
        return "redirect:/";
    }

    @GetMapping("{votingId}/candidate")
    public String createCandidatePage(Model model, @PathVariable("votingId") int id) {
        Voting voting = votingService.get(id);
        model.addAttribute("voting", voting);
        Candidate candidate = new Candidate();
        candidate.setVotingId(voting.getId());
        model.addAttribute("candidate", candidate);
        return "voting-candidate";
    }

    @PostMapping("{votingId}/candidate")
    public String createCandidate(Model model, @PathVariable("votingId") int id, @ModelAttribute Candidate candidate) {
        candidateService.create(candidate);
        System.out.println(candidate);
        return "redirect:/voting/" + candidate.getVotingId();
    }

    @GetMapping("{id}/start")
    public String start(@PathVariable int id, Model model) {
        Voting voting = votingService.get(id);
        if (voting != null) {
            voting.setActive(true);
            votingService.update(voting);
            model.addAttribute("success", "Success, voting started!");
        } else {
            model.addAttribute("error", "Error, invalid voting!");
        }
        return "redirect:/";
    }

    @GetMapping("{id}/stop")
    public String stop(@PathVariable int id, Model model) {
        Voting voting = votingService.get(id);
        if (voting != null) {
            voting.setActive(false);
            votingService.update(voting);
            model.addAttribute("success", "Success, voting stopped!");
        } else {
            model.addAttribute("error", "Error, invalid voting!");
        }
        return "redirect:/";
    }

    @GetMapping("{id}/results")
    public String results(@PathVariable int id, Model model) {
        Voting voting = votingService.getWithCandidates(id);
        model.addAttribute("voting", voting);
        List<Vote> votes = voteService.getByVoting(voting.getId());
        model.addAttribute("votes", votes);
        List<Candidate> candidates = voting.getCandidates().stream()
                .peek(candidate -> {
                    candidate.setVotes(votes.stream()
                            .filter(vote -> vote.getCandidateId() == candidate.getId())
                            .collect(Collectors.toList())
                    );
                })
                .collect(Collectors.toList());
        model.addAttribute("candidates", candidates);
        Candidate winner = candidates.stream()
                .sorted(Comparator.comparingInt(c -> c.getVotes().size()))
                .reduce(null, (acc, c) -> {
                    if (c.getVotes().isEmpty()) return acc;
                    if (acc == null) return c;
                   if (c.getVotes().size() > acc.getVotes().size()) {
                       return c;
                   }
                   return acc;
                });
        model.addAttribute("winner", winner);
        return "voting-results";
    }
}
