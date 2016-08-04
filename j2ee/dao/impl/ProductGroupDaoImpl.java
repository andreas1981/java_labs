package com.kuzmenko.dao.impl;

import com.kuzmenko.dao.api.ProductGroupDao;
import com.kuzmenko.db_util.DataSource;
import com.kuzmenko.entity.ProductGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrew_Elena on 02.08.2016.
 */
public class ProductGroupDaoImpl implements ProductGroupDao{
    private static ProductGroupDao productGroupDao;
    private static final String SELECT_ALL_PRODUCTGROUPS = "SELECT * FROM luckysales.productgroup";
    private static final String SELECT_PRODUCTGROUP_BY_ID = "SELECT * FROM luckysales.productgroup WHERE id = ?";
    private static final String DEL_PRODUCTGROUP_BY_ID = "DELETE FROM luckysales.productgroup WHERE id = ?";
    private static final String CREATE_PRODUCTGROUP = "INSERT INTO luckysales.productgroup VALUES (?, ?, ?, ?)";

    private DataSource dataSource;
    private ProductGroupDaoImpl() {
        dataSource = DataSource.getInstance();
    }
    public static ProductGroupDao getInstance() {
        if (productGroupDao == null) {
            synchronized (UserDaoImpl.class) {
                if (productGroupDao == null) {
                    productGroupDao = new ProductGroupDaoImpl();
                }
            }
        }
        return productGroupDao;
    }

    @Override
    public List<ProductGroup> findAll() {
        Connection connection = dataSource.getConnection();
        List<ProductGroup> productGroups = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTGROUPS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ProductGroup productGroup = new ProductGroup();
                productGroup.setId(resultSet.getLong("id"));
                productGroup.setName(resultSet.getString("name"));
                productGroup.setDescription(resultSet.getString("description"));

                productGroups.add(productGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productGroups;
    }

    @Override
    public ProductGroup findById(long id) {
        Connection connection = dataSource.getConnection();
        ProductGroup productGroup = new ProductGroup();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCTGROUP_BY_ID);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                productGroup.setId(id);
                productGroup.setName(resultSet.getString("name"));
                productGroup.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productGroup;
    }

    @Override
    public boolean delete(long id) {
        int countDel = 0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DEL_PRODUCTGROUP_BY_ID);
            ps.setLong(1, id);
            countDel = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (countDel > 0);
    }

    @Override
    public boolean create(ProductGroup product) {
        return false;
    }
}
