package com.hpeu.elaticsearch.UserService;

import com.hpeu.elaticsearch.Entity.User;
import com.hpeu.elaticsearch.UserDao.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(User user){
        repository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }
}
