package com.sprintboot.restfull_webservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = " User first name should not be null or empty")
    private String firstName;

    // User Last name should not be null or empty
    @NotEmpty
    private String lastName;

    // User emaol should not be null or empty
    @NotEmpty
    @Email(message = "User email should be valid")
    private String email;
}
