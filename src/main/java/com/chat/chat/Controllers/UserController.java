package com.chat.chat.Controllers;

import com.chat.chat.DAO.UserDAO;
import com.chat.chat.Models.User;
import com.chat.chat.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
   @Autowired
    UserDAO userDAO;
   @Autowired
   UserServices userServices;
   @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public boolean register (@RequestBody User user) {
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
        return true;
    }
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return  userDAO.findAll();
    }
}
