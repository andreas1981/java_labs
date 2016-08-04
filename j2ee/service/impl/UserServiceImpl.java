package com.kuzmenko.service.impl;

import com.kuzmenko.Transformer;
import com.kuzmenko.dao.api.UserDao;
import com.kuzmenko.dao.impl.UserDaoImpl;
import com.kuzmenko.dto.UserDto;
import com.kuzmenko.entity.User;
import com.kuzmenko.service.api.UserService;

import java.util.List;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (UserServiceImpl.class) {
                if (instance == null) {
                    instance = new UserServiceImpl();
                }
            }
        }
        return instance;
    }
    @Override
    public List<UserDto> findAll()
    {   UserDao userDao = UserDaoImpl.getInstance();
        List<User> usersList = userDao.findAll();
        List<UserDto> userDtos = Transformer.transformUserToUserDTOList(usersList);
        return userDtos;
    }
    @Override
    public UserDto getUserById(long id) {
        //todo add implementation
        UserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.findById(id);

        UserDto userDto = Transformer.transformUserToUserDTO(user);
        return userDto;
    }
    @Override
    public void createUser(UserDto userDto) {
        //todo add implementation
    }

    @Override
    public boolean deleteUser(long id) {
        //todo add implementation
        boolean userDel;
        UserDao userDao = UserDaoImpl.getInstance();
        userDel = userDao.delete(id);
        return userDel;
    }
}
