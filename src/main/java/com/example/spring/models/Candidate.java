package com.example.spring.models;

import java.util.List;

public class Candidate extends Model<Integer> {

    private static int idCounter = 1;
    private String name;
    private String description;
    private int votingId;
    private Voting voting;
    private List<Vote> votes;

    public Candidate() {
        this.id = idCounter++;
    }

    public Candidate(String name, String description, int votingId) {
        this();
        this.name = name;
        this.description = description;
        this.votingId = votingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotingId() {
        return votingId;
    }

    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", votingId=" + votingId +
                ", id=" + id +
                '}';
    }
}
