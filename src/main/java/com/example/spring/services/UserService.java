package com.example.spring.services;

import com.example.spring.models.User;
import com.example.spring.repositories.interfaces.IUserRepository;
import com.example.spring.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public User get(Integer key) {
        return userRepository.read(key);
    }

    @Override
    public List<User> getAll() {
        return userRepository.readAll();
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public User getByIp(String ip) {
        return userRepository.getByIp(ip);
    }
}
