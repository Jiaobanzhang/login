package com.example.login.controller;

import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // Only allow cross-origin access from http://localhost:3000.
@RestController
@RequestMapping("/api")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public String login(@RequestParam String username, @RequestParam String password) {
    boolean success = userService.login(username, password);
    return success ? "Login Successful" : "Invalid Username or Password";
  }
}