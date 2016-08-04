package com.kuzmenko;

import com.kuzmenko.dto.ProductGroupDto;
import com.kuzmenko.dto.UserDto;
import com.kuzmenko.service.api.ProductGroupService;
import com.kuzmenko.service.api.UserService;
import com.kuzmenko.service.impl.ProductGroupServiceImpl;
import com.kuzmenko.service.impl.UserServiceImpl;

import java.util.List;

/**
 * Created by Andrew_Elena on 23.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        /*UserService service = UserServiceImpl.getInstance();

        UserDto userDto = service.getUserById(2);

        System.out.println(userDto);*/

        UserService service1 = UserServiceImpl.getInstance();
        List<UserDto> list = service1.findAll();
        System.out.println(list);

        //UserService service2 = UserServiceImpl.getInstance();
        //service2.deleteUser(1);

        ProductGroupService service2 = ProductGroupServiceImpl.getInstance();
        List<ProductGroupDto> list1 = service2.findAll();
        System.out.println(list1);

    }
}
