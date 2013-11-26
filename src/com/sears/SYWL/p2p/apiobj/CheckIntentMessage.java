package com.sears.SYWL.p2p.apiobj;

import java.util.ArrayList;

public class CheckIntentMessage implements IJSONable {
	
	private boolean availability;
	private ArrayList<Integer> intentList;
	
	public CheckIntentMessage(boolean availability, ArrayList<Integer> intentList) {
		this.availability=availability;
		this.intentList=intentList;
	}

	@Override
	public String toJSON() {
		return JsonWrapper.wrap(this, "CheckIntent");
	}

}
