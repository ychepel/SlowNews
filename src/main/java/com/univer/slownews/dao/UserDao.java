package com.univer.slownews.dao;

import com.univer.slownews.model.User;
import com.univer.slownews.servlet.ApplicationServletContextListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> findAll() throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT u FROM User u");
            return query.getResultList();
        } finally {
            manager.close();
        }
    }

    public void addUser(User user) throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(user);
            transaction.commit();
        } finally {
            manager.close();
        }
    }

}
