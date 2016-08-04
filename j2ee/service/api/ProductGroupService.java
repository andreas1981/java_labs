package com.kuzmenko.service.api;

import com.kuzmenko.dto.ProductGroupDto;

import java.util.List;

/**
 * Created by Andrew_Elena on 22.06.2016.
 */
public interface ProductGroupService {
    public List<ProductGroupDto> findAll();
    ProductGroupDto getProductGroupById(long id);

    void createProductGroup(ProductGroupDto productGroupDto);

    boolean deleteProductGroup(long id);
}
