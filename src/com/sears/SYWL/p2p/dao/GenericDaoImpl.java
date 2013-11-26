package com.sears.SYWL.p2p.dao;


import org.hibernate.Session;

public class GenericDaoImpl<T> implements GenericDao<T> {
	
	protected Session getSession() {
        return HibernateUtil.getSession();
    }
	@Override
    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        HibernateUtil.beginTransaction();
        hibernateSession.delete(entity);
        HibernateUtil.commitTransaction();
       // HibernateUtil.closeSession();
    }


	@Override
	public void save(T entity) {
        Session hibernateSession = this.getSession();
        HibernateUtil.beginTransaction();
        hibernateSession.saveOrUpdate(entity);
        HibernateUtil.commitTransaction();
      // HibernateUtil.closeSession();
    }
	
}
