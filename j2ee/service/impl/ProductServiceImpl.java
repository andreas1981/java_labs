package com.kuzmenko.service.impl;

import com.kuzmenko.Transformer;
import com.kuzmenko.dao.api.ProductDao;
import com.kuzmenko.dao.impl.ProductDaoImpl;
import com.kuzmenko.dto.ProductDto;
import com.kuzmenko.entity.Product;
import com.kuzmenko.service.api.ProductService;

import java.util.List;

/**
 * Created by Andrew_Elena on 22.06.2016.
 */
public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl instance = null;

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (ProductServiceImpl.class) {
                if (instance == null) {
                    instance = new ProductServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<ProductDto> findAll()
    {   ProductDao productDao = ProductDaoImpl.getInstance();
        List<Product> productsList = productDao.findAll();
        List<ProductDto> productDtos = Transformer.transformProductToProductDTOList(productsList);
        return productDtos;
    }
    @Override
    public ProductDto getProductById(long id) {
        //todo add implementation
        ProductDao userDao = ProductDaoImpl.getInstance();
        Product product = userDao.findById(id);

        ProductDto productDto = Transformer.transformProductToProductDTO(product);
        return productDto;
    }
    @Override
    public void createProduct(ProductDto userDto) {
        //todo add implementation
    }

    @Override
    public boolean deleteProduct(long id) {
        //todo add implementation
        boolean productDel;
        ProductDao userDao = ProductDaoImpl.getInstance();
        productDel = userDao.delete(id);
        return productDel;
    }
}
