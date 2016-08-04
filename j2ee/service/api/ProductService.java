package com.kuzmenko.service.api;

import com.kuzmenko.dto.ProductDto;

import java.util.List;

/**
 * Created by Andrew_Elena on 22.06.2016.
 */
public interface ProductService {
    public List<ProductDto> findAll();

    ProductDto getProductById(long id);

    void createProduct(ProductDto productDto);

    boolean deleteProduct(long id);
}
