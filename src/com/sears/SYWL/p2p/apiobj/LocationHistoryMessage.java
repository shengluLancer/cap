package com.sears.SYWL.p2p.apiobj;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sears.SYWL.p2p.dal.Location;

public class LocationHistoryMessage implements IJSONable {
	
	Set<Location> locations;
	
	public LocationHistoryMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public LocationHistoryMessage(Set<Location> set) {
		this.locations=set;
	}
	

	@Override
	public String toJSON() {
		return JsonWrapper.wrap(this, "LocationHistory");
	}
	
}
