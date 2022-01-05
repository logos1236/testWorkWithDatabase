package com.example.test;

import com.example.test.entity.News;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ApplicationEntityManagerCase {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-project");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        News newNews = new News();
        newNews.setName("Test1");
        entityManager.persist(newNews);
        entityManager.flush();

        entityManager.find(News.class, 1l);
        entityManager.find(News.class, 1l);

        entityTransaction.commit();
        entityManager.close();
    }
}
