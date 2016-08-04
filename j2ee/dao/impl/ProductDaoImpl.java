package com.kuzmenko.dao.impl;

import com.kuzmenko.dao.api.ProductDao;
import com.kuzmenko.db_util.DataSource;
import com.kuzmenko.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrew_Elena on 02.08.2016.
 */
public class ProductDaoImpl implements ProductDao {
    private static ProductDao productDao;
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM luckysales.products";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM luckysales.products WHERE id = ?";
    private static final String DEL_PRODUCT_BY_ID = "DELETE FROM luckysales.products WHERE id = ?";
    private static final String CREATE_PRODUCT = "INSERT INTO luckysales.products VALUES (?, ?, ?, ?)";

    private DataSource dataSource;
    private ProductDaoImpl() {
        dataSource = DataSource.getInstance();
    }
    public static ProductDao getInstance() {
        if (productDao == null) {
            synchronized (UserDaoImpl.class) {
                if (productDao == null) {
                    productDao = new ProductDaoImpl();
                }
            }
        }
        return productDao;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = dataSource.getConnection();
        List<Product> products = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));

                products.add(product);
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
        return products;
    }

    @Override
    public Product findById(long id) {
        Connection connection = dataSource.getConnection();
        Product product = new Product();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                product.setId(id);
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean delete(long id) {
        int countDel = 0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DEL_PRODUCT_BY_ID);
            ps.setLong(1, id);
            countDel = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (countDel > 0);
    }

    @Override
    public boolean create(Product product) {
        return false;
    }
}
