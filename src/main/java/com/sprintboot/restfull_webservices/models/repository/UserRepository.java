package com.sprintboot.restfull_webservices.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintboot.restfull_webservices.models.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
