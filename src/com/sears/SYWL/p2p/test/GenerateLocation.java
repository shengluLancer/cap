package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.*;

public class GenerateLocation {

	public void generate() {
		// TODO Auto-generated method stub
		Location location0 = new Location();
		location0.setAddress("Zhong Nan Hai");

		location0.setLatitude(0.0);
		location0.setLongitude(0.0);
;
		TestDriver.locationList.add(location0);
		
		
		Location location1 = new Location();
		location1.setAddress("Tian An Men");
		location1.setLatitude(0.1);
		location1.setLongitude(0.1);

		TestDriver.locationList.add(location1);
		
		
		Location location2 = new Location();
		location2.setAddress("White House");
		location2.setLatitude(100.21);
		location2.setLongitude(102.36);
		TestDriver.locationList.add(location2);
	}
}
