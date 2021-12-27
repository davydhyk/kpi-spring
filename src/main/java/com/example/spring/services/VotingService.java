package com.example.spring.services;

import com.example.spring.models.Candidate;
import com.example.spring.models.Voting;
import com.example.spring.repositories.interfaces.ICandidateRepository;
import com.example.spring.repositories.interfaces.IVotingRepository;
import com.example.spring.services.interfaces.IVotingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService implements IVotingService {

    private final IVotingRepository votingRepository;
    private final ICandidateRepository candidateRepository;

    public VotingService(IVotingRepository votingRepository, ICandidateRepository candidateRepository) {
        this.votingRepository = votingRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Voting> getByUser(int userId) {
        return votingRepository.getByUser(userId);
    }

    @Override
    public Voting getWithCandidates(int id) {
        Voting voting = votingRepository.read(id);
        voting.setCandidates(candidateRepository.getByVoting(voting.getId()));
        return voting;
    }

    @Override
    public Voting getByCandidate(int candidateId) {
        Candidate candidate = candidateRepository.read(candidateId);
        return votingRepository.read(candidate.getVotingId());
    }

    @Override
    public void create(Voting voting) {
        votingRepository.create(voting);
    }

    @Override
    public Voting get(Integer key) {
        return votingRepository.read(key);
    }

    @Override
    public List<Voting> getAll() {
        return votingRepository.readAll();
    }

    @Override
    public void update(Voting voting) {
        votingRepository.update(voting);
    }

    @Override
    public void delete(Integer key) {
        votingRepository.delete(key);
    }
}
