package com.example.spring.services.interfaces;

import com.example.spring.models.Pageable;
import com.example.spring.models.Voting;

import java.util.List;

public interface IVotingService extends IGenericService<Voting, Integer> {

    List<Voting> getAllPaged(Pageable pageable);

    List<Voting> getByUser(int userId);

    Voting getWithCandidates(int id);

    Voting getByCandidate(int candidateId);
}
