package com.sears.SYWL.p2p.dao;


import org.hibernate.Session;

public class GenericDaoImpl<T> implements GenericDao<T> {
	
	protected Session getSession() {
        return HibernateUtil.getSession();
    }
	@Override
    public synchronized void delete(T entity) {
        Session hibernateSession = this.getSession();
        HibernateUtil.beginTransaction();
        hibernateSession.delete(entity);
        HibernateUtil.commitTransaction();
       // HibernateUtil.closeSession();
    }


	@Override
	public synchronized void save(T entity) {
        Session hibernateSession = this.getSession();
        HibernateUtil.beginTransaction();
        hibernateSession.saveOrUpdate(entity);
        HibernateUtil.commitTransaction();
        try {
			Thread.sleep(20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			HibernateUtil.rollbackTransaction();
			System.out.println("mamaibi");
			save(entity);
		}
      // HibernateUtil.closeSession();
    }
	
	@Override
	public synchronized void merge(T entity) {
        Session hibernateSession = this.getSession();
        HibernateUtil.beginTransaction();
        hibernateSession.merge(entity);
        HibernateUtil.commitTransaction();
      // HibernateUtil.closeSession();
    }
}
