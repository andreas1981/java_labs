package com.kuzmenko.dao.api;

import com.kuzmenko.entity.User;

import java.util.List;

/**
 * Created by Andrew_Elena on 14.07.2016.
 */
public interface UserDao {
    List<User> findAll();

    User findById(long id);

    boolean delete(long id);

    boolean create(User user);
}
