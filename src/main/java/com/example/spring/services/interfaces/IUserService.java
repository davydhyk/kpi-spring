package com.example.spring.services.interfaces;

import com.example.spring.models.User;

public interface IUserService extends IGenericService<User, Integer> {

    User getByIp(String ip);
}
