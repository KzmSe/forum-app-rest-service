package com.forum.service.service;

import com.forum.service.dao.UserDao;
import com.forum.service.exceptions.UserCredentialsException;
import com.forum.service.model.Action;
import com.forum.service.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User addUser(User user) throws UserCredentialsException, SQLException {
        return userDao.addUser(user);
    }

    @Override
    public User getUserByEmail(String email) throws UserCredentialsException, SQLException {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<Action> getActionListByRoleId(int id) throws SQLException {
        return userDao.getActionListByRoleId(id);
    }

}