package com.univer.slownews.hibernate;

import com.univer.slownews.dao.HibernateUtil;
import org.hibernate.Session;

public class TestHibernateUtil {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        NewsEntity news = session.get(NewsEntity.class, 3);
//        System.out.println(news.getTeaserLink());
        UserEntity user = session.get(UserEntity.class, 2);
        System.out.println(user.getName());
//        session.close();
        HibernateUtil.shutdown();
    }
}
