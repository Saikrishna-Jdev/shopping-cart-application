package com.sca.webapp.service.user;

import com.sca.webapp.entity.User;
import com.sca.webapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        log.info("Getting the All the Users : {}",repository.findAll());

        return repository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        log.info("Getting the User by UserId: {}",userId);

        return repository.findById(userId).get();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
