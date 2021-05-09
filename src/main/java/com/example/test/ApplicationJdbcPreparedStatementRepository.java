package com.example.test;

import com.example.test.repository.impl.PreparedStatementRepository;

public class ApplicationJdbcPreparedStatementRepository {
    public static void main(String[] args) {
        PreparedStatementRepository preparedStatementRepository = new PreparedStatementRepository();

        preparedStatementRepository.executeQuery();

        /*productJdbcPreparedStatementRepository.executeUpdateQuery("test6");
        productJdbcPreparedStatementRepository.executeQuery();

        productJdbcPreparedStatementRepository.executeDeleteQuery("test6");
        productJdbcPreparedStatementRepository.executeQuery();

        productJdbcPreparedStatementRepository.executeDeleteQueryWithSavePoint();
        productJdbcPreparedStatementRepository.executeQuery();*/

        preparedStatementRepository.executeBatchQuery();
        preparedStatementRepository.executeQuery();
    }
}
