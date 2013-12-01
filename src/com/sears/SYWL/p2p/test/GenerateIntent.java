package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.*;


public class GenerateIntent {
	
	public void generate() {
		// TODO Auto-generated method stub
		DeliverIntent intent0 = new DeliverIntent();
		intent0.setLatitude(40.445818);
		intent0.setLongitude(-79.948859);
		intent0.setDate(System.currentTimeMillis());
		intent0.setReward(100);
		intent0.setStore_id(1);
		intent0.setCapacity(20);
		intent0.setDue_time(System.currentTimeMillis() + 100000);
		intent0.setActive(0);
		TestDriver.intentList.add(intent0);
		
		
		DeliverIntent intent1 = new DeliverIntent();
		intent1.setLatitude(40.444285);
		intent1.setLongitude(-79.945554);
		intent1.setDate(System.currentTimeMillis());
		intent1.setReward(80);
		intent1.setStore_id(1);
		intent1.setCapacity(20);
		intent1.setDue_time(System.currentTimeMillis() + 2000000);
		intent0.setActive(0);
		TestDriver.intentList.add(intent1);
		
		
		DeliverIntent intent2 = new DeliverIntent();
		intent2.setLatitude(40.444320);
		intent2.setLongitude(-79.940986);
		intent2.setDate(System.currentTimeMillis());
		intent2.setReward(80);
		intent2.setStore_id(2);
		intent2.setCapacity(20);
		intent2.setDue_time(System.currentTimeMillis() + 1000000);
		intent0.setActive(0);
		TestDriver.intentList.add(intent2);
	}
}
