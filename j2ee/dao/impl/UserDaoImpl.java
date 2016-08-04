package com.kuzmenko.dao.impl;

import com.kuzmenko.dao.api.UserDao;
import com.kuzmenko.db_util.DataSource;
import com.kuzmenko.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kovantonlenko on 7/14/2016.
 */
public class UserDaoImpl implements UserDao {

    private static UserDao userDao;
    private static final String SELECT_ALL_USERS = "SELECT * FROM luckysales.users";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM luckysales.users WHERE id = ?";
    private static final String DEL_USER_BY_ID = "DELETE FROM luckysales.users WHERE id = ?";
    private static final String CREATE_USER = "INSERT INTO luckysales.users VALUES (?, ?, ?, ?)";

    private DataSource dataSource;

    private UserDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }

    @Override
    public List<User> findAll() {
        Connection connection = dataSource.getConnection();
        List<User> users = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setSecondName(resultSet.getString("secondname"));
                //user.setAge(resultSet.getString("age"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public User findById(long id) {
        Connection connection = dataSource.getConnection();
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user.setId(id);
                user.setFirstName(resultSet.getString("firstname"));
                user.setSecondName(resultSet.getString("secondname"));
                user.setAge(resultSet.getString("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean delete(long id) {
        int countDel = 0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DEL_USER_BY_ID);
            ps.setLong(1, id);
            countDel = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (countDel > 0);
    }

    @Override
    public boolean create(User user) {
        return false;
    }
}
