package com.example.test.repository.impl;

import com.example.test.jdbcConnect.impl.JdbcConnection;
import com.example.test.repository.ProductRepository;
import lombok.NonNull;

import java.sql.*;

public class PreparedStatementRepository implements ProductRepository {
    @Override
    public void executeQuery() {
        String query = "SELECT * from product WHERE id >= ?";
        Integer idBorder = 2;

        try (Connection conn = JdbcConnection.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idBorder);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id") + " : " + rs.getString("name"));
            }

            System.out.println("\n=====================\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeUpdateQuery(@NonNull String name) {
        String query = "INSERT INTO product (name) VALUES(?)";

        try(Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeDeleteQuery(String name) {
        String query = "DELETE FROM product WHERE name=?";

        try (Connection connection = JdbcConnection.getConnection()) {
            connection.setAutoCommit(false);

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,name);
                statement.executeUpdate();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeDeleteQueryWithSavePoint() {
        String insertQuery = "INSERT INTO product (name) VALUES(?)";
        String deleteQuery = "DELETE FROM product WHERE name=?";

        try (Connection connection = JdbcConnection.getConnection()) {
            connection.setAutoCommit(false);

            try {
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1,"One");
                insertStatement.executeUpdate();
                Savepoint savepointOne = connection.setSavepoint("savepointOne");

                insertStatement.setString(1,"Two");
                insertStatement.executeUpdate();
                Savepoint savepointTwo = connection.setSavepoint("savepointTwo");

                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setString(1,"One");
                deleteStatement.executeUpdate();

                deleteStatement.setString(1,"Two");
                deleteStatement.executeUpdate();

                connection.rollback(savepointTwo);
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeBatchQuery() {

        try (Connection connection = JdbcConnection.getConnection()) {
            connection.setAutoCommit(false);

            try {
                Statement insertStatement = connection.createStatement();

                String insertQuery1 = "INSERT INTO product (name) VALUES('Ivan')";
                String insertQuery2 = "INSERT INTO product (name) VALUES('Peter')";
                String insertQuery3 = "INSERT INTO product (name) VALUES('Vitaly')";

                insertStatement.addBatch(insertQuery1);
                insertStatement.addBatch(insertQuery2);
                insertStatement.addBatch(insertQuery3);

                insertStatement.executeBatch();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
