package com.example.test.jdbcConnect.impl;

import com.example.test.jdbcConnect.JdbcConnectionInterface;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcPoolConnection implements JdbcConnectionInterface {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/test_db";
    private static final String userName = "test";
    private static final String password = "test";

    private static volatile ComboPooledDataSource cpds;

    private ComboPooledDataSource init() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl(dbUrl);
        cpds.setUser(userName);
        cpds.setPassword(password);

        // the settings below are optional -- c3p0 can work with defaults
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);

        return cpds;
    }


    @Override
    public Connection getConnection() throws PropertyVetoException, SQLException {
        if (cpds == null) {
            synchronized (JdbcPoolConnection.class) {
                if (cpds == null) {
                    cpds = init();
                }
            }
        }

        return cpds.getConnection();
    }
}
