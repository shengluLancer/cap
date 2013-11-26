package com.sears.SYWL.p2p.dao;



import com.sears.SYWL.p2p.dal.*;

public interface OrderDao extends GenericDao<Order>{

	public Order loadOrderById(int orderId);
}
