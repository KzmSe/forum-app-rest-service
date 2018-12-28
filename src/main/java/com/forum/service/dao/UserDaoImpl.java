package com.forum.service.dao;

import com.forum.service.constants.MessageConstants;
import com.forum.service.constants.UserConstants;
import com.forum.service.exceptions.UserCredentialsException;
import com.forum.service.model.Action;
import com.forum.service.model.Role;
import com.forum.service.model.User;
import com.forum.service.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String ADD_USER_SQL = "insert into user(email, password, token, status, id_role, first_name, last_name, image) values(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String GET_EMAIL_COUNT_SQL = "select count(email) as count from user where email = ?";
    private final String GET_USER_BY_EMAIL_SQL = "select * from user where email = ?";
    private final String GET_ACTION_LIST_BY_ROLE_ID_SQL = "select * from role_action ra inner join action ac on ra.id_action=ac.id_action where id_role = ?";

    @Override
    public User addUser(User user) throws UserCredentialsException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (!isEmailValid(user.getEmail())) {
                throw new UserCredentialsException(MessageConstants.ERROR_MESSAGE_DUPLICATE_EMAIL);
            }

            con = DbUtil.getConnection();
            ps = con.prepareStatement(ADD_USER_SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getToken());
            ps.setInt(4, user.getStatus());
            ps.setInt(5, user.getRole().getId());
            ps.setString(6, user.getFirstname());
            ps.setString(7, user.getLastname());
            ps.setString(8, user.getImagePath());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

        } finally {
            DbUtil.closeAll(con, ps);
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserCredentialsException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_USER_BY_EMAIL_SQL);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id_user"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getInt("status"));
                user.setToken(rs.getString("token"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setImagePath(rs.getString("image"));

                Role role = new Role();
                role.setId(rs.getInt("id_role"));
                user.setRole(role);

            } else {
                throw new UserCredentialsException(MessageConstants.ERROR_MESSAGE_USER_NOT_FOUND);
            }

        } finally {
            DbUtil.closeAll(con, ps, rs);
        }

        return user;
    }

    @Override
    public List<Action> getActionListByRoleId(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Action> list = new ArrayList<>();

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ACTION_LIST_BY_ROLE_ID_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Action action = new Action();
                action.setId(rs.getInt("id_action"));
                action.setActionType(rs.getString("action_type"));

                list.add(action);
            }

        } finally {
            DbUtil.closeAll(con, ps);
        }

        return list;
    }


    //private methods
    private boolean isEmailValid(String email) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_EMAIL_COUNT_SQL);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt("count") == 0) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DbUtil.closeAll(con, ps);
        }

        return result;
    }


}