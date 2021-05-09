package com.example.test.jdbcConnect;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcConnectionInterface {
    public Connection getConnection() throws PropertyVetoException, SQLException;
}
