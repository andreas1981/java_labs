package com.kuzmenko;

import com.kuzmenko.dto.ProductDto;
import com.kuzmenko.dto.ProductGroupDto;
import com.kuzmenko.dto.UserDto;
import com.kuzmenko.entity.Product;
import com.kuzmenko.entity.ProductGroup;
import com.kuzmenko.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrew_Elena on 14.07.2016.
 */
public class Transformer {
    public static UserDto transformUserToUserDTO(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setAge(user.getAge());
        return userDto;
    }
    public static List<UserDto> transformUserToUserDTOList(List<User> usersList) {
        List<UserDto> list = new LinkedList<>();
        for (User user: usersList)
        {
           UserDto userDto = transformUserToUserDTO(user);
           list.add(userDto);
        }
        return list;
    }
    public static ProductDto transformProductToProductDTO(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        return productDto;
    }
    public static List<ProductDto> transformProductToProductDTOList(List<Product> productsList) {
        List<ProductDto> list = new LinkedList<>();
        for (Product product: productsList)
        {
            ProductDto userDto = transformProductToProductDTO((product));
            list.add(userDto);
        }
        return list;
    }

    public static ProductGroupDto transformProductGroupToProductGroupDTO(ProductGroup productGroup) {
        ProductGroupDto productGroupDto = new ProductGroupDto();
        productGroupDto.setId(productGroup.getId());
        productGroupDto.setName(productGroup.getName());
        productGroupDto.setDescription(productGroup.getDescription());
        return productGroupDto;
    }
    public static List<ProductGroupDto> transformProductGroupToProductGroupDTOList(List<ProductGroup> productGroupsList) {
        List<ProductGroupDto> list = new LinkedList<>();
        for (ProductGroup productGroup: productGroupsList)
        {
            ProductGroupDto productGroupDto = transformProductGroupToProductGroupDTO((productGroup));
            list.add(productGroupDto);
        }
        return list;
    }
}
