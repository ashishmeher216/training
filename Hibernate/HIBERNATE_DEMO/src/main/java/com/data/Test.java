package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class Test {
   public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata m= new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory fac=m.getSessionFactoryBuilder().build();
        Session sess=fac.openSession();
        Transaction tx=sess.beginTransaction();
        Employee e=new Employee();
        e.setId(555);
        e.setFirstname("Palki");
        e.setLastname("Sharma");
        sess.save(e);
        
        Employee e2=new Employee();
        e2.setId(666);
        e2.setFirstname("Subramaniam");
        e2.setLastname("Jaishankar");
        sess.save(e2);
        
        tx.commit();
        fac.close();
        sess.close();
        System.out.println("Done...");
   }
}