package com.example.spring.models;

public class User extends Model<Integer> {

    private static int idCounter = 1;
    private String ip;

    public User() {
        this.id = idCounter++;
    }

    public User(String ip) {
        this();
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public User setIp(String ip) {
        this.ip = ip;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "ip='" + ip + '\'' +
                '}';
    }
}
