package com.sears.SYWL.p2p.dao;

import org.hibernate.Session;

import com.sears.SYWL.p2p.dal.*;

public class LocationDaoImpl extends GenericDaoImpl<Location> implements LocationDao {

	public Location loadLocationById(int location_id) {
		 Location t = new Location();
		 Session hibernateSession = this.getSession();
	     HibernateUtil.beginTransaction(); 
	     t = (Location)hibernateSession.load(t.getClass(), location_id);
	     HibernateUtil.commitTransaction();
	     return t;
	}
}
