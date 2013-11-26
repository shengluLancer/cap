package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.*;

public class GenerateUser {
	
	public void generate(){
		
		User user0 = new User();
		user0.setfName("Rui");
		user0.setlName("Hua");
		user0.setbDay("25");
		user0.setbMonth("12");
		user0.setbYear("1990");
		user0.setEmail("rhua@china.com");
		user0.setPhoneNumber("1512307853");
		user0.setPoints(100);
		TestDriver.userList.add(user0);	
		
		User user1 = new User();
		user1.setfName("Dianxia");
		user1.setlName("Yang");
		user1.setbDay("05");
		user1.setbMonth("01");
		user1.setbYear("1990");
		user1.setEmail("dianxia@LINKEDIN.com");
		user1.setPhoneNumber("619230-1241");
		user1.setPoints(100);
		TestDriver.userList.add(user1);	
		
		User user2 = new User();
		user2.setfName("Sheng");
		user2.setlName("Lu");
		user2.setbDay("25");
		user2.setbMonth("12");
		user2.setbYear("1992");
		user2.setEmail("lancer@AMAZON.com");
		user2.setPhoneNumber("231923241");
		user2.setPoints(80);
		TestDriver.userList.add(user2);	
	}
}
