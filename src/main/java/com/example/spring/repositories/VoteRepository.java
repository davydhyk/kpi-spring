package com.example.spring.repositories;

import com.example.spring.models.Candidate;
import com.example.spring.models.Vote;
import com.example.spring.repositories.interfaces.ICandidateRepository;
import com.example.spring.repositories.interfaces.IVoteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VoteRepository extends GenericRepository<Vote, Integer> implements IVoteRepository {

    private final ICandidateRepository candidateRepository;

    public VoteRepository(ICandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Vote> getByCandidates(List<Candidate> candidates) {
        return entities.values().stream()
                .filter(vote -> candidates.contains(vote.getCandidate()))
                .collect(Collectors.toList());
    }

    @Override
    public Vote getByCandidatesAndUser(List<Candidate> candidates, int userId) {
        return entitiesWithCandidates().stream()
                .filter(vote -> candidates.contains(vote.getCandidate()) && vote.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public List<Vote> entitiesWithCandidates() {
        return entities.values().stream()
                .peek(vote -> vote.setCandidate(candidateRepository.read(vote.getCandidateId())))
                .collect(Collectors.toList());
    }
}
