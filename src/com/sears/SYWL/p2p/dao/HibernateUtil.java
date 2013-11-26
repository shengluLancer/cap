package com.sears.SYWL.p2p.dao;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
 

public class HibernateUtil {
 
	private static final SessionFactory sessionFactory;
	private static final Session hibernateSession;
	
	static {
		try {
		   // Create the SessionFactory from standard (hibernate.cfg.xml)
		   // config file.
		   sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		   hibernateSession = sessionFactory.openSession();
		} catch (Throwable ex) {
		   // Log the exception.
	       System.err.println("Initial SessionFactory creation failed." + ex);
		   throw new ExceptionInInitializerError(ex);
	    }
    }
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}
 
	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}
 
	public static void closeSession() {
		HibernateUtil.getSession().close();
	}
 
	public static Session getSession() {
		return hibernateSession;
	}
}