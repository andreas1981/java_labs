package com.kuzmenko.service.api;

import com.kuzmenko.dto.UserDto;

import java.util.List;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public interface UserService {

    List<UserDto> findAll();

    UserDto getUserById(long id);

    void createUser(UserDto userDto);

    boolean deleteUser(long id);
}
