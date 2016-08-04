package com.kuzmenko.db_util;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * Created by Andrew_Elena on 14.07.2016.
 */
public class DataSource {
    private static DataSource dataSource;

    public static DataSource getInstance()
    {
        if (dataSource == null)
        {
            synchronized (DataSource.class)
            {
                if (dataSource == null)
                   dataSource = new DataSource();
            }
        }
        return dataSource;
    }

    private DataSource() {
    }
    public Connection getConnection() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection conn = null;
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/luckysales?serverTimezone=UTC");
            cpds.setUser("root");
            cpds.setPassword("root");

            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(10);
            cpds.setMaxPoolSize(50);

            conn = cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
