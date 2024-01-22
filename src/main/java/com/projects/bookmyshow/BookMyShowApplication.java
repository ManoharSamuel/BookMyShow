package com.projects.bookmyshow;

import com.projects.bookmyshow.controllers.UserController;
import com.projects.bookmyshow.dtos.UserSignUpRequestDTO;
import com.projects.bookmyshow.dtos.UserSignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
    private final UserController userController;

    @Autowired
    public BookMyShowApplication(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        UserSignUpRequestDTO userSignUpRequestDTO = new UserSignUpRequestDTO();
        userSignUpRequestDTO.setEmail("abcTwo@gmail.com");
        userSignUpRequestDTO.setPassword("welcome");
        userSignUpRequestDTO.setName("Test_User");
        UserSignUpResponseDTO userSignUpResponseDTO = userController.userUpdate(userSignUpRequestDTO);
        System.out.println(userSignUpResponseDTO.getMessage());
    }
    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

}
