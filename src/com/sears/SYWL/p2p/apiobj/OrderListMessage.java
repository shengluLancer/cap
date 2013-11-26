package com.sears.SYWL.p2p.apiobj;

import java.util.ArrayList;

import com.sears.SYWL.p2p.dal.Order;

public class OrderListMessage implements IJSONable {
	ArrayList<Order> locations;
	
	public OrderListMessage(ArrayList<Order> list) {
		this.locations=(ArrayList<Order>)list.clone();
	}
	

	@Override
	public String toJSON() {
		return JsonWrapper.wrap(this, "OrderList");
	}
}
