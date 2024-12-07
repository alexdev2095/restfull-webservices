package com.sprintboot.restfull_webservices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.sprintboot.restfull_webservices.dto.UserDto;
import com.sprintboot.restfull_webservices.exception.ErrorDetails;
import com.sprintboot.restfull_webservices.exception.ResourceNotFoundException;
import com.sprintboot.restfull_webservices.models.entity.User;
import com.sprintboot.restfull_webservices.models.service.IUserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private IUserService userService;

    // build create user API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.creatUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        UserDto updatedUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("usuario borrado correctamente", HttpStatus.OK);
    }

    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<ErrorDetails>
    // handlerResourceNotFoundException(ResourceNotFoundException exception,
    // WebRequest webRequest) {

    // ErrorDetails errorDetails = new ErrorDetails(
    // LocalDateTime.now(),
    // exception.getMessage(),
    // webRequest.getDescription(false),
    // "USER_NOT_FOUND");

    // return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    // }

}
