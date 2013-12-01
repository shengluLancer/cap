package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.*;

public class GenerateSummaryEntry {

	public void generate() {
		// TODO Auto-generated method stub
		SummaryEntry SE0 = new SummaryEntry();
		SE0.setDeliverMethod("first_method");
		SE0.setDeliverFee(12.5);
		SE0.setStoreId(2);
		TestDriver.summaryEntryList.add(SE0);	
		
		SummaryEntry SE1 = new SummaryEntry();
		SE1.setDeliverMethod("second_method");
		SE1.setStoreId(2);
		SE1.setDeliverFee(13.0);
		TestDriver.summaryEntryList.add(SE1);	
		
		SummaryEntry SE3 = new SummaryEntry();
		SE3.setDeliverMethod("third_method");
		SE3.setStoreId(1);
		SE3.setDeliverFee(13.5);
		TestDriver.summaryEntryList.add(SE3);
	}	
}
