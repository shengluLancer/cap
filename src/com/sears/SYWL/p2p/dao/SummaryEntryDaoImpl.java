package com.sears.SYWL.p2p.dao;

import org.hibernate.Session;

import com.sears.SYWL.p2p.dal.*;

public class SummaryEntryDaoImpl extends GenericDaoImpl<SummaryEntry> implements SummaryEntryDao {

	public SummaryEntry loadSummaryEntryById(int summaryEntry_id) {
		 SummaryEntry t = new SummaryEntry();
		 Session hibernateSession = this.getSession();
	     HibernateUtil.beginTransaction(); 
	     t = (SummaryEntry)hibernateSession.load(t.getClass(), summaryEntry_id);
	     HibernateUtil.commitTransaction();
	     return t;
	}
}
