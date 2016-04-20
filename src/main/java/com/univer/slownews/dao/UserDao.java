package com.univer.slownews.dao;

import com.univer.slownews.entity.User;
import com.univer.slownews.servlet.ApplicationServletContextListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDao {

    public List<User> getUsers() throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT u FROM User u");
            List<User> users = query.getResultList();
            return users;
        } catch (RuntimeException e ) {
            throw new DaoException("Cannot get users from DB", e);
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
        } catch (RuntimeException e ) {
            throw new DaoException("Cannot add user to DB", e);
        } finally {
            manager.close();
        }
    }

    public User getUserByName(String userName) throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        try {
            Query query = manager.createQuery("SELECT u FROM User u WHERE name = :name");
            query.setParameter("name", userName);
            return (User) query.getSingleResult();
        } catch (RuntimeException e ) {
            throw new DaoException("Cannot get user by name from DB", e);
        } finally {
            manager.close();
        }
    }
}
