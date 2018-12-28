package com.forum.service.service;

import com.forum.service.exceptions.UserCredentialsException;
import com.forum.service.model.Action;
import com.forum.service.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User addUser(User user) throws UserCredentialsException, SQLException;

    User getUserByEmail(String email) throws UserCredentialsException, SQLException;

    List<Action> getActionListByRoleId(int id) throws SQLException;

}
