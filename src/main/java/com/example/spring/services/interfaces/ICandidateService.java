package com.example.spring.services.interfaces;

import com.example.spring.models.Candidate;

import java.util.List;

public interface ICandidateService extends IGenericService<Candidate, Integer> {

    List<Candidate> getByVoting(int votingId);
}