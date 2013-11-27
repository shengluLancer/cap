package com.sears.SYWL.p2p.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import com.sears.SYWL.p2p.dal.*;


public class DeliverIntentDaoImpl extends GenericDaoImpl<DeliverIntent> implements DeliverIntentDao{

	
		public DeliverIntent loadIntentById(int intentId){
			 DeliverIntent t = new DeliverIntent();
			 Session hibernateSession = this.getSession();
			 HibernateUtil.beginTransaction(); 
		     t = (DeliverIntent)hibernateSession.load(t.getClass(), intentId);
		     HibernateUtil.commitTransaction();
		     return t;
		}

		
		public List<DeliverIntent> queryActiveIntentPool(int store_id,  long dueTime){
			List<DeliverIntent> result = new ArrayList<DeliverIntent>();
			String sql_1 = "select TB_DELIVER_INTENT.DELIVER_ID from TB_DELIVER_INTENT where STORE_ID = " + store_id;
			String sql_2 = " AND DUE_TIME < " + dueTime;
			String sql_3 = " AND ACTIVE = 0";
			String sql = sql_1 + sql_2 + sql_3;
			System.out.println(dueTime + "  !!!!dududududududue " + store_id + " store_idididididididi!!!!!!!!!");
			Session hibernateSession = this.getSession();
			HibernateUtil.beginTransaction();
			Query query = hibernateSession.createSQLQuery(sql);
			@SuppressWarnings("unchecked")
			List<Integer> idList = query.list();
			System.out.println(idList);
			for(Integer id : idList){
				DeliverIntent intent = new DeliverIntent();
				intent = (DeliverIntent)hibernateSession.load(intent.getClass(), id);
				result.add(intent);
			}
			HibernateUtil.commitTransaction();
			return result;
		}

		@Override
		public boolean deleteIntentById(int intentID) {
			boolean result = true;
			try{
				DeliverIntent intent = loadIntentById(intentID);
				super.delete(intent);
			}
		    catch(Exception e){
		    	result = false;
		    }
			return result;
		}
}
