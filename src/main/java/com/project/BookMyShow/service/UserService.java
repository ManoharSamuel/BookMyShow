package com.project.BookMyShow.service;

import com.project.BookMyShow.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User login(String email, String password);
    User singUp(String name, String email, String password);

}
