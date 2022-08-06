package com.example.simpletest.service.impl;

import com.example.simpletest.dao.UserDao;
import com.example.simpletest.dao.impl.UserDaoImpl;
import com.example.simpletest.model.User;
import com.example.simpletest.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();



    @Override
    public boolean register(User user) {
        if(user.getFirstName() == null || user.getLastName() == null || user.getUsername() == null || user.getPassword() == null)
            return false;
        if(userDao.getUserByUsername(user.getUsername()) != null && userDao.getUserByUsername(user.getUsername()).size()!=0 )
            return false;
        userDao.saveUser(user);
        return true;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || password == null)
            return null;
        return userDao.getUserByUsernameAndPassword(username, password);
    }

}
