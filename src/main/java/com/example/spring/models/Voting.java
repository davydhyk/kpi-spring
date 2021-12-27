package com.example.spring.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Voting extends Model<Integer> {

    private static int idCounter = 1;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private boolean active;
    private int userId;
    private User user;
    private List<Candidate> candidates;

    public Voting() {
        this.id = idCounter++;
    }

    public Voting(String title, Date startDate, Date endDate, boolean active, int userId) {
        this();
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public Voting setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Voting setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Voting setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public Voting setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Voting setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                ", userId=" + userId +
                '}';
    }
}
