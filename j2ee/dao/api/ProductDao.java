package com.kuzmenko.dao.api;

import com.kuzmenko.entity.Product;

import java.util.List;

/**
 * Created by Andrew_Elena on 02.08.2016.
 */
public interface ProductDao {
    List<Product> findAll();

    Product findById(long id);

    boolean delete(long id);

    boolean create(Product user);
}
