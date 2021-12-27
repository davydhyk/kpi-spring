package com.example.spring.repositories;

import com.example.spring.models.User;
import com.example.spring.repositories.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends GenericRepository<User, Integer> implements IUserRepository {

    @Override
    public User getByIp(String ip) {
        return entities.values().stream()
                .filter(u -> u.getIp().equals(ip))
                .findFirst()
                .orElse(null);
    }
}
