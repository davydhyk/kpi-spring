package com.example.spring.repositories.interfaces;

import com.example.spring.models.Candidate;

import java.util.List;

public interface ICandidateRepository extends IGenericRepository<Candidate, Integer> {

    List<Candidate> getByVoting(int id);
}
