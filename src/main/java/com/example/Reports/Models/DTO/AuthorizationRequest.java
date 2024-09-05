package com.example.Reports.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorizationRequest {

    @NotBlank(message = "username can't be empty")
    private String username;

    @NotBlank(message = "password can't be empty")
    private String password;

}
