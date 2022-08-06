package com.example.simpletest.dao;

import com.example.simpletest.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserByUsername(String username);

    User getUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User getUserByUsernameAndPassword(String username, String password);

}
