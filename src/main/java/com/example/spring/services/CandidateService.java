package com.example.spring.services;

import com.example.spring.models.Candidate;
import com.example.spring.repositories.interfaces.ICandidateRepository;
import com.example.spring.services.interfaces.ICandidateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements ICandidateService {

    private final ICandidateRepository candidateRepository;

    public CandidateService(ICandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> getByVoting(int votingId) {
        return candidateRepository.getByVoting(votingId);
    }

    @Override
    public void create(Candidate candidate) {
        candidateRepository.create(candidate);
    }

    @Override
    public Candidate get(Integer key) {
        return candidateRepository.read(key);
    }

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.readAll();
    }

    @Override
    public void update(Candidate candidate) {
        candidateRepository.update(candidate);
    }

    @Override
    public void delete(Integer key) {
        candidateRepository.delete(key);
    }
}
