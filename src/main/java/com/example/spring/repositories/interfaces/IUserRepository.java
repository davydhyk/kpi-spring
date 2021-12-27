package com.example.spring.repositories.interfaces;

import com.example.spring.models.User;

public interface IUserRepository extends IGenericRepository<User, Integer> {

    User getByIp(String ip);
}
