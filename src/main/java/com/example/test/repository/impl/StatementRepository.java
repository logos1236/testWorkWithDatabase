package com.example.test.repository.impl;

import com.example.test.jdbcConnect.impl.JdbcConnection;
import com.example.test.repository.ProductRepository;

import java.sql.*;

public class StatementRepository implements ProductRepository {
    public void executeQuery() {
        String query = "select * from product WHERE id >= 2";

        try (Connection conn = JdbcConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("id") + " : " + rs.getString("name"));
            }
            System.out.println("\n=====================\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdateQuery(String name) {
        String query = "INSERT INTO product (name) VALUES('"+name+"')";

        try (Connection conn = JdbcConnection.getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeDeleteQuery(String name) {
        String query = "DELETE FROM product WHERE name='"+name+"'";

        try (Connection conn = JdbcConnection.getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
