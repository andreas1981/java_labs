package com.kuzmenko.dao.api;

import com.kuzmenko.entity.ProductGroup;

import java.util.List;

/**
 * Created by Andrew_Elena on 02.08.2016.
 */
public interface ProductGroupDao {
    List<ProductGroup> findAll();

    ProductGroup findById(long id);

    boolean delete(long id);

    boolean create(ProductGroup productGroup);
}
