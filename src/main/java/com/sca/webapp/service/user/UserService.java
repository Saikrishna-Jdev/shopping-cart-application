package com.sca.webapp.service.user;

import com.sca.webapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int userId);
    User updateUser(User user);
}
