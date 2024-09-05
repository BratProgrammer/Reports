package com.example.Reports.Services;

import com.example.Reports.Models.DTO.RegistrationRequest;
import com.example.Reports.Models.user.Role;
import com.example.Reports.Models.user.User;
import com.example.Reports.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void createUser(RegistrationRequest registrationRequest) {
        userRepository.save(createUserFromRegistrationRequest(registrationRequest));
    }


    private User createUserFromRegistrationRequest(RegistrationRequest request) {
        return new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail(),
                Role.USER
        );
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
