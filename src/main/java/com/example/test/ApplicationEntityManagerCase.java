package com.example.test;

import com.example.test.entity.News;
import com.example.test.entity.NewsComment;
import com.example.test.entity.id.NewsCommentId;

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

        //News newNews = new News();
        //newNews.setName("Test1");
        //entityManager.persist(newNews);
        News news = entityManager.find(News.class, 13l);

        NewsCommentId newsCommentId = new NewsCommentId(news);
        NewsComment newsComment = new NewsComment(newsCommentId, "12345");
        entityManager.persist(newsComment);

        entityTransaction.commit();
        entityManager.close();
    }
}
