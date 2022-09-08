package com.ashish.projectzero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
        EntityManager em = emf.createEntityManager();
        
//        Alien a = em.find(Alien.class,3);
        
        Alien a = new Alien();
        a.setAid(4);
        a.setAname("Pathikrit");
        a.setTech("Electronics");
        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        System.out.println(a);
    }
}
