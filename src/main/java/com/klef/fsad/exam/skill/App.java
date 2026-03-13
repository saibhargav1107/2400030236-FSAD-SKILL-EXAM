package com.klef.fsad.exam.skill;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Library l = new Library("Java Book", "Programming Basics", new Date());
        session.save(l);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Inserted successfully");
    }
}