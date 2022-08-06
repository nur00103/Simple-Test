package com.example.simpletest.service;

import com.example.simpletest.model.User;

public interface UserService {

    boolean register(User user);

    User login(String username, String password);
}
