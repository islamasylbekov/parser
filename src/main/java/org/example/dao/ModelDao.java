package org.example.dao;

import org.example.config.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ModelDao<T>{

    private final SessionFactory sessionFactory;

    public ModelDao(SessionFactory  sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(List<T>tList){
        SessionFactory factory = HibernateUtility.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        tList.forEach(x -> session.save(x));
        transaction.commit();
        session.close();
    }
}
