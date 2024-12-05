package com.sprintboot.restfull_webservices.models.service;

import java.util.List;

import com.sprintboot.restfull_webservices.dto.UserDto;
import com.sprintboot.restfull_webservices.models.entity.User;

public interface IUserService {
    UserDto creatUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
