package com.sprintboot.restfull_webservices.models.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sprintboot.restfull_webservices.dto.UserDto;
import com.sprintboot.restfull_webservices.mapper.UserMapper;
import com.sprintboot.restfull_webservices.models.entity.User;
import com.sprintboot.restfull_webservices.models.repository.UserRepository;
import com.sprintboot.restfull_webservices.models.service.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public UserDto creatUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User userExits = userRepository.findById(user.getId()).get();
        userExits.setFirstName(user.getFirstName());
        userExits.setLastName(user.getLastName());
        userExits.setEmail(user.getEmail());
        User updatUser = userRepository.save(userExits);
        return UserMapper.mapToUserDto(updatUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
