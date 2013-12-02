package com.sears.SYWL.p2p.dao;

import org.hibernate.Session;

import com.sears.SYWL.p2p.dal.*;

public class StoreDaoImpl extends GenericDaoImpl<Store> implements StoreDao {

	@Override
	public synchronized Store loadStoreById(int store_id) {
		 Store t = new Store();
		 Session hibernateSession = this.getSession();
	     HibernateUtil.beginTransaction(); 
	     t = (Store)hibernateSession.load(t.getClass(), store_id);
	     HibernateUtil.commitTransaction();
	     return t;
	}

	@Override
	public synchronized String loadNameById(int store_id) {
		 Store t = new Store();
		 Session hibernateSession = this.getSession();
	     HibernateUtil.beginTransaction(); 
	     t = (Store)hibernateSession.load(t.getClass(), store_id);
	     HibernateUtil.commitTransaction();
	     return t.getStoreName();
	}
		
}
