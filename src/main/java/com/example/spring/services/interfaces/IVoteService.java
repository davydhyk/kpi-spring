package com.example.spring.services.interfaces;

import com.example.spring.models.Vote;

import java.util.List;

public interface IVoteService extends IGenericService<Vote, Integer> {

    List<Vote> getByVoting(int votingId);
    List<Vote> getByVotingAndUser(int votingId, int userId);
}
