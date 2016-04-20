package com.univer.slownews.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationServletContextListener implements ServletContextListener {

    private static EntityManagerFactory entityManagerFactory;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        entityManagerFactory.close();
    }

    public static EntityManager createEntityManager() {
        if (entityManagerFactory == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return entityManagerFactory.createEntityManager();
    }
}
