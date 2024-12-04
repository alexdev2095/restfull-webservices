package com.sprintboot.restfull_webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sprintboot.restfull_webservices.entity.User;
import com.sprintboot.restfull_webservices.repository.UserRepository;
import com.sprintboot.restfull_webservices.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User creatUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User userExits = userRepository.findById(user.getId()).get();
        userExits.setFirstName(user.getFirstName());
        userExits.setLastName(user.getLastName());
        userExits.setEmail(user.getEmail());
        return userRepository.save(userExits);
    }

}
