package com.sca.webapp.service.user;

import com.sca.webapp.entity.User;
import com.sca.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {

        return repository.findAll();
    }

    @Override
    public User getUserById(int userId) {

        return repository.findById(userId).get();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
