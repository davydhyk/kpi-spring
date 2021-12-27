package com.example.spring.repositories.interfaces;

import com.example.spring.models.Candidate;
import com.example.spring.models.Vote;

import java.util.List;

public interface IVoteRepository extends IGenericRepository<Vote, Integer> {

    List<Vote> getByCandidates(List<Candidate> candidates);
    List<Vote> getByCandidatesAndUser(List<Candidate> candidates, int userId);
}
