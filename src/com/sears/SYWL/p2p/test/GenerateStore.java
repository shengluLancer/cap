package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.DeliverIntent;
import com.sears.SYWL.p2p.dal.Store;

public class GenerateStore {
	public void generate() {
		// TODO Auto-generated method stub
		Store store0 = new Store();
		store0.setStoreName("Union Grill");
		TestDriver.storeList.add(store0);
		
		Store store1 = new Store();
		store1.setStoreName("Starbucks");
		TestDriver.storeList.add(store1);
		
		Store store2 = new Store();
		store2.setStoreName("Rose Tea Cafe");
		TestDriver.storeList.add(store2);
		
		Store store3 = new Store();
		store3.setStoreName("How Lee Food");
		TestDriver.storeList.add(store3);
		
	}
}
