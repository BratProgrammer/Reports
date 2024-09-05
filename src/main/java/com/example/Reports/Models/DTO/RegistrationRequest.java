package com.example.Reports.Models.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationRequest {

    @NotBlank(message = "username can't be empty")
    private String username;

    @NotBlank(message = "password can't be empty")
    private String password;

    @NotBlank(message = "email can't be empty")
    @Email(message = "Email address must be in the format user@example.com")
    private String email;

}
