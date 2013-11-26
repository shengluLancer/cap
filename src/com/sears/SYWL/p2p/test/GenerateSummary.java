package com.sears.SYWL.p2p.test;
import com.sears.SYWL.p2p.dal.*;


public class GenerateSummary {

	public void generate() {
		// TODO Auto-generated method stub
		Summary S0 = new Summary();
		S0.setSubmittedDate(System.currentTimeMillis());
		TestDriver.summaryList.add(S0);	
		Summary S1 = new Summary();
		S1.setSubmittedDate(System.currentTimeMillis() + 1000);
		TestDriver.summaryList.add(S1);
	}	
}
