package com.example.test.repository;

import lombok.NonNull;

public interface ProductRepository {
    void executeQuery();
    void executeUpdateQuery(@NonNull String name);
    void executeDeleteQuery(@NonNull String name);
}
