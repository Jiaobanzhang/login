package com.example.login.service;

public interface UserService {
    /**
     * Login validation
     * @param username Username
     * @param password Password
     * @return Returns true if login is successful, false otherwise
     */
    boolean login(String username, String password);
}

