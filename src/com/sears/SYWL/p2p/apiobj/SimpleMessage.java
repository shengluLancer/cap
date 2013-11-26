package com.sears.SYWL.p2p.apiobj;

public class SimpleMessage implements IJSONable {
	
	String message;
	
	public SimpleMessage(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	@Override
	public String toJSON() {
		return JsonWrapper.wrap(this, "SimpleMessage");
	}

}
