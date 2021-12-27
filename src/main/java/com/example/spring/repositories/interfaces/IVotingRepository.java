package com.example.spring.repositories.interfaces;

import com.example.spring.models.Pageable;
import com.example.spring.models.Voting;

import java.util.List;

public interface IVotingRepository extends IGenericRepository<Voting, Integer> {

    List<Voting> getAllPaged(Pageable pageable);

    List<Voting> getByUser(int userId);
}
