package com.sprintboot.restfull_webservices.service;

import java.util.List;

import com.sprintboot.restfull_webservices.entity.User;

public interface UserService {
    User creatUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
