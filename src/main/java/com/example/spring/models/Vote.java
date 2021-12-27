package com.example.spring.models;

public class Vote extends Model<Integer> {

    private static int idCounter = 1;
    private int candidateId;
    private Candidate candidate;
    private int userId;
    private User user;

    public Vote() {
        this.id = idCounter++;
    }

    public Vote(int candidateId, int userId) {
        this();
        this.candidateId = candidateId;
        this.userId = userId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", userId=" + userId +
                '}';
    }
}
