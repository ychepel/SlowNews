package com.univer.slownews.dao;

import com.univer.slownews.model.NewsEntity;
import com.univer.slownews.model.UserEntity;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NewsEntity news = session.get(NewsEntity.class, 3);
        System.out.println(news.getTeaserLink());
//        session.close();
        HibernateUtil.shutdown();
    }
}
