package com.example.test.jdbcConnect.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    private static final String dbUrl = "jdbc:postgresql://localhost:5432/test_db";
    private static final String userName = "test";
    private static final String password = "test";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }
}
