package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.Order;

public class GenerateOrder {
	
	public void generate() {
		// TODO Auto-generated method stub
		Order order0 = new Order();
		order0.setOrderName("chicken");
		
		order0.setCount(15);
		order0.setTax(1.0);	
		order0.setTotalPrice(18);
		order0.setPreTaxPrice(13);
		TestDriver.orderList.add(order0);
		
		Order order1 = new Order();
		order1.setOrderName("banana");
		order1.setCount(14);
		order1.setTax(1.0);
		TestDriver.orderList.add(order1);
		
		Order order2 = new Order();
		order2.setOrderName("buble tea");
		order2.setCount(2);
		order2.setTax(1.0);
		TestDriver.orderList.add(order2);
	}	
}
