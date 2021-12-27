package com.example.spring.services;

import com.example.spring.models.Candidate;
import com.example.spring.models.Vote;
import com.example.spring.repositories.interfaces.ICandidateRepository;
import com.example.spring.repositories.interfaces.IVoteRepository;
import com.example.spring.services.interfaces.IVoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService implements IVoteService {

    private final IVoteRepository voteRepository;
    private final ICandidateRepository candidateRepository;

    public VoteService(IVoteRepository voteRepository, ICandidateRepository candidateRepository) {
        this.voteRepository = voteRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Vote> getByVoting(int votingId) {
        List<Candidate> candidates = candidateRepository.getByVoting(votingId);
        return voteRepository.getByCandidates(candidates);
    }

    @Override
    public Vote getByVotingAndUser(int votingId, int userId) {
        List<Candidate> candidates = candidateRepository.getByVoting(votingId);
        return voteRepository.getByCandidatesAndUser(candidates, userId);
    }

    @Override
    public void create(Vote vote) {
        voteRepository.create(vote);
    }

    @Override
    public Vote get(Integer key) {
        return voteRepository.read(key);
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.readAll();
    }

    @Override
    public void update(Vote vote) {
        voteRepository.update(vote);
    }

    @Override
    public void delete(Integer key) {
        voteRepository.delete(key);
    }
}
