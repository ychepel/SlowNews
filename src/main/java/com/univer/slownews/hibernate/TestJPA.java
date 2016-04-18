package com.univer.slownews.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        UserEntity user = new UserEntity();
        user.setEmail("c@c");
        user.setPassword("security");
        user.setName("user-531");

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

}
