package com.sears.SYWL.p2p.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	public int getNumOfGoods(int summaryEntry_id){
		String sql_1 = "select SUM(COUNT) from TB_ENTRY_ORDER JOIN TB_ORDER USING (ORDER_ID) where ENTRY_ID = " + summaryEntry_id;
		String sql = sql_1;
		Session hibernateSession = this.getSession();
		HibernateUtil.beginTransaction();
		Query query = hibernateSession.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<BigDecimal> idList = query.list();
		System.out.println(idList.get(0) + " number");
		HibernateUtil.commitTransaction();
		return idList.get(0).intValueExact();
	}
}
