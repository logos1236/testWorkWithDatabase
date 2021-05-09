package com.example.test;

import com.example.test.repository.impl.StatementRepository;

public class ApplicationJdbcStatementRepository {

	public static void main(String[] args) {
		StatementRepository statementRepository = new StatementRepository();

		statementRepository.executeUpdateQuery("test4");
		statementRepository.executeQuery();

		statementRepository.executeDeleteQuery("test4");
		statementRepository.executeQuery();
	}

}
