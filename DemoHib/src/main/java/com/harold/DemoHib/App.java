package com.harold.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien donald = new Alien();
        AlienName an = new AlienName();
        an.setFname("Lena");
        an.setLname("Macdonald");
        an.setMname("Cathrine");
        
        donald.setAid(102);
        donald.setAname(an);
        donald.setColor("Green");
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);       
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //donald = (Alien)session.get(Alien.class, 102);
        session.save(donald);
        tx.commit();
        System.out.println(donald);
    }
    
    private void fetch(int id){
    	Alien alien = new Alien();
    	Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);       
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
    	alien = (Alien)session.get(Alien.class, 102);

        tx.commit();
        System.out.println(alien);
    }
    
    private void save(Alien alien){
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);       
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
        System.out.println(alien);
    }
    
    
}
