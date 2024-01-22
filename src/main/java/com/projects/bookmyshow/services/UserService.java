package com.projects.bookmyshow.services;

import com.projects.bookmyshow.exceptions.UserAlreadyExistsException;
import com.projects.bookmyshow.models.User;
import com.projects.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userSignUp(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User with the email ID "+email+" already exists");
        }

        User user = new User();
        user.setEmail(email);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public User updateUser(String email, String name) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        User user = userOptional.get();
        user.setName(name);

        return userRepository.save(user);
    }
}
