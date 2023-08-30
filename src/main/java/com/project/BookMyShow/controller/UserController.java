package com.project.BookMyShow.controller;

import com.project.BookMyShow.controller.utils.UserControllerUtil;
import com.project.BookMyShow.dto.UserSignUpRequestDTO;
import com.project.BookMyShow.dto.UserSignUpResponseDTO;
import com.project.BookMyShow.models.User;
import com.project.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO userSignUpRequestDTO) {
        User user;
        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();
        try{
            if (UserControllerUtil.validateUserSignUpRequestDTO(userSignUpRequestDTO)) {
                user = userService.singUp(userSignUpRequestDTO.getName(), userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPassword());
                userSignUpResponseDTO.setId(user.getId());
                userSignUpResponseDTO.setName(user.getName());
                userSignUpResponseDTO.setEmail(user.getEmailID());
                userSignUpResponseDTO.setResponseCode("200");
                userSignUpResponseDTO.setResponseMessage("Sign Up was successful");
            }
        } catch (Exception e) {
            userSignUpResponseDTO.setResponseCode("500");
            userSignUpResponseDTO.setResponseMessage("Sign Up was not successful");
        }
        return userSignUpResponseDTO;
    }
}
