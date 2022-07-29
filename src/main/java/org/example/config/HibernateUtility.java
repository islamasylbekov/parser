package org.example.config;

import org.example.models.json.*;
import org.example.models.xls.XLSModel;
import org.example.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    public static SessionFactory factory;

    private HibernateUtility() {
    }

    public static synchronized SessionFactory getSessionFactory() {

        if (factory == null) {
            factory = new Configuration().configure(Util.HIBERNATE_CFG_PATH)
                    .addAnnotatedClass(JsomModel.class)
                    .addAnnotatedClass(Transfer.class)
                    .addAnnotatedClass(Transfers.class)
                    .addAnnotatedClass(Amount.class)
                    .addAnnotatedClass(ConversionRate.class)
                    .addAnnotatedClass(Entry.class)
                    .addAnnotatedClass(Entry.class)
                    .addAnnotatedClass(Participant.class)
                    .addAnnotatedClass(XLSModel.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}
