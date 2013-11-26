package com.sears.SYWL.p2p.dao;

import org.hibernate.Session;

import com.sears.SYWL.p2p.dal.Order;


public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao{
	
	public Order loadOrderById(int orderId){
		 Order t = new Order();
		 Session hibernateSession = this.getSession();
	     HibernateUtil.beginTransaction(); 
	     t = (Order)hibernateSession.load(t.getClass(), orderId);
	     HibernateUtil.commitTransaction();
	     return t;
	}
	
}
