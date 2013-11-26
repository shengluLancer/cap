package com.sears.SYWL.p2p.dao;

import org.hibernate.Session;

import com.sears.SYWL.p2p.dal.*;

public class SummaryDaoImpl extends GenericDaoImpl<Summary> implements SummaryDao {

	@Override
	public Summary loadSummaryById(int summary_id) {
		 Summary t = new Summary();
		 Session hibernateSession = this.getSession();
	     HibernateUtil.beginTransaction(); 
	     t = (Summary)hibernateSession.load(t.getClass(), summary_id);
	     HibernateUtil.commitTransaction();
	     return t;
	}
}
