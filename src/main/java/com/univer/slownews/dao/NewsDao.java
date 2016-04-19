package com.univer.slownews.dao;

import com.univer.slownews.model.News;
import com.univer.slownews.model.User;
import com.univer.slownews.servlet.ApplicationServletContextListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {

    public List<News> getNewsByUser(String userName) throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT n FROM News n WHERE n.user.name = :name");
            query.setParameter("name", userName);
            List<News> news = query.getResultList();
            return news;
        } catch (RuntimeException e ) {
            throw new DaoException("Cannot get news for user from DB", e);
        } finally {
            manager.close();
        }
    }

    public void addNews(News news) throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(news);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new DaoException("Cannot add news to DB", e);
        } finally {
            manager.close();
        }
    }

    public void removeNewsById(List<Integer> newsId) throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            for(int id : newsId) {
                News news = manager.find(News.class, id);
                manager.remove(news);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new DaoException("Cannot remove news from DB", e);
        } finally {
            manager.close();
        }
    }

}
