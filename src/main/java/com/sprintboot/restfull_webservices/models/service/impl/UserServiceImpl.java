package com.sprintboot.restfull_webservices.models.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sprintboot.restfull_webservices.dto.UserDto;
import com.sprintboot.restfull_webservices.mapper.IAutoUserMapper;
import com.sprintboot.restfull_webservices.mapper.UserMapper;
import com.sprintboot.restfull_webservices.models.entity.User;
import com.sprintboot.restfull_webservices.models.repository.UserRepository;
import com.sprintboot.restfull_webservices.models.service.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto creatUser(UserDto userDto) {

        // Convert UserDTO into User JPA Entity
        // User user = UserMapper.mapToUser(userDto);

        // Use Model Mapper
        // User user = modelMapper.map(userDto, User.class);

        User user = IAutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        // Convert User JPA Entity into UserDTO
        // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        // Use Model Mapper
        // UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        UserDto savedUserDto = IAutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        // return UserMapper.mapToUserDto(user);
        // return modelMapper.map(user, UserDto.class);
        return IAutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        // return users.stream().map(UserMapper::mapToUserDto)
        // .collect(Collectors.toList());

        // return users.stream().map((user) -> modelMapper.map(users, UserDto.class))
        // .collect(Collectors.toList());

        return users.stream().map((user) -> IAutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User userExits = userRepository.findById(user.getId()).get();
        userExits.setFirstName(user.getFirstName());
        userExits.setLastName(user.getLastName());
        userExits.setEmail(user.getEmail());
        User updatUser = userRepository.save(userExits);
        // return UserMapper.mapToUserDto(updatUser);
        // return modelMapper.map(updatUser, UserDto.class);
        return IAutoUserMapper.MAPPER.mapToUserDto(updatUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
