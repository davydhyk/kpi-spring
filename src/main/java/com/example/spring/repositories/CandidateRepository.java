package com.example.spring.repositories;

import com.example.spring.models.Candidate;
import com.example.spring.repositories.interfaces.ICandidateRepository;
import com.example.spring.repositories.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CandidateRepository extends GenericRepository<Candidate, Integer> implements ICandidateRepository {

    public CandidateRepository() {
        Candidate candidate = new Candidate("First candidate", "Description of first candidate", 1);
        this.create(candidate);
        Candidate candidate1 = new Candidate("Second candidate", "Description of second candidate", 1);
        this.create(candidate1);
        Candidate candidate2 = new Candidate("Third candidate", "Description of third candidate", 2);
        this.create(candidate2);
        Candidate candidate3 = new Candidate("Fourth candidate", "Description of fourth candidate", 2);
        this.create(candidate3);
    }

    @Override
    public List<Candidate> getByVoting(int id) {
        return entities.values().stream()
                .filter(candidate -> candidate.getVotingId() == id)
                .collect(Collectors.toList());
    }
}
