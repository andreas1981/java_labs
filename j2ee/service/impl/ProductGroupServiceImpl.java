package com.kuzmenko.service.impl;

import com.kuzmenko.Transformer;
import com.kuzmenko.dao.api.ProductGroupDao;
import com.kuzmenko.dao.impl.ProductGroupDaoImpl;
import com.kuzmenko.dto.ProductGroupDto;
import com.kuzmenko.entity.ProductGroup;
import com.kuzmenko.service.api.ProductGroupService;

import java.util.List;

/**
 * Created by Andrew_Elena on 22.06.2016.
 */
public class ProductGroupServiceImpl implements ProductGroupService {
    private static ProductGroupServiceImpl instance = null;

    public static ProductGroupServiceImpl getInstance() {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (ProductGroupServiceImpl.class) {
                if (instance == null) {
                    instance = new ProductGroupServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<ProductGroupDto> findAll()
    {
        ProductGroupDao productGroupDao = ProductGroupDaoImpl.getInstance();
        List<ProductGroup> productGroupsList = productGroupDao.findAll();
        List<ProductGroupDto> productGroupDtos = Transformer.transformProductGroupToProductGroupDTOList(productGroupsList);
        return productGroupDtos;
    }

    @Override
    public ProductGroupDto getProductGroupById(long id) {
        ProductGroupDao productGroupDao = ProductGroupDaoImpl.getInstance();
        ProductGroup productGroup = productGroupDao.findById(id);

        ProductGroupDto productGroupDto = Transformer.transformProductGroupToProductGroupDTO(productGroup);
        return productGroupDto;
    }

    @Override
    public void createProductGroup(ProductGroupDto productGroupDto) {

    }

    @Override
    public boolean deleteProductGroup(long id) {
        return false;
    }
}
