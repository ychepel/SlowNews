package com.univer.slownews.dao;

import com.univer.slownews.model.User;
import com.univer.slownews.servlet.ApplicationServletContextListener;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SentencePartDao {

    public List<String> getParts(String type) throws DaoException {
        EntityManager manager = ApplicationServletContextListener.createEntityManager();
        try {
            Query query = manager.createNativeQuery("SELECT value FROM sentence_part WHERE type = :type");
            query.setParameter("type", type);
            List<String> parts = query.getResultList();
            return parts;
        } catch (RuntimeException e ) {
            throw new DaoException("Cannot get sentence parts from DB", e);
        } finally {
            manager.close();
        }
    }
}
