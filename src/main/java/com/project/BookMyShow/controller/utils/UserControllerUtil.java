package com.project.BookMyShow.controller.utils;

import com.project.BookMyShow.dto.UserSignUpRequestDTO;

public class UserControllerUtil {
    public static boolean validateUserSignUpRequestDTO(UserSignUpRequestDTO userSignUpRequestDTO) {
        return !userSignUpRequestDTO.getName().isEmpty() && !userSignUpRequestDTO.getEmail().isEmpty() &&
                !userSignUpRequestDTO.getPassword().isEmpty();
    }
}
