package com.projects.bookmyshow.controllers;

import com.projects.bookmyshow.dtos.UserSignUpRequestDTO;
import com.projects.bookmyshow.dtos.UserSignUpResponseDTO;
import com.projects.bookmyshow.exceptions.UserAlreadyExistsException;
import com.projects.bookmyshow.models.User;
import com.projects.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserSignUpResponseDTO userSignUp(UserSignUpRequestDTO userSignUpRequestDTO) {
        User user = new User();
        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();
        try {
            user = userService.userSignUp(userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPassword());
            userSignUpResponseDTO.setUserId(user.getId());
            userSignUpResponseDTO.setMessage("Sign up was successful");
        } catch (UserAlreadyExistsException e) {
            userSignUpResponseDTO.setMessage("Sign up was not successful");
            //e.printStackTrace();

        }

        return userSignUpResponseDTO;
    }

    public UserSignUpResponseDTO userUpdate(UserSignUpRequestDTO userSignUpRequestDTO) {
        User user = new User();
        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();
        try {
            user = userService.updateUser(userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getName());
            userSignUpResponseDTO.setUserId(user.getId());
            userSignUpResponseDTO.setMessage("Update was successful");
        } catch (UserAlreadyExistsException e) {
            userSignUpResponseDTO.setMessage("Update was not successful");
            //e.printStackTrace();

        }

        return userSignUpResponseDTO;
    }
}
