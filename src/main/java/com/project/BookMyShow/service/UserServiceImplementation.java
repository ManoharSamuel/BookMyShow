package com.project.BookMyShow.service;

import com.project.BookMyShow.exceptions.InvalidCredentialsException;
import com.project.BookMyShow.exceptions.UserAlreadyExistsException;
import com.project.BookMyShow.exceptions.UserNotFoundException;
import com.project.BookMyShow.models.User;
import com.project.BookMyShow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User does not exist with the given email of "+email);
        }
        User user = optionalUser.get();
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new InvalidCredentialsException("Credentials are not valid");
        }
    }

    @Override
    public User singUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists with the given email of "+email);
        }
        User user = new User();
        user.setName(name);
        user.setEmailID(email);
        user.setPassword(password);

        return userRepository.save(user);
    }
}
