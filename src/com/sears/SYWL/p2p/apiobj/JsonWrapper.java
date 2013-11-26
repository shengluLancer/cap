package com.sears.SYWL.p2p.apiobj;

import com.google.gson.Gson;
//this is a utility class for convert java object into json
public class JsonWrapper {
	public static String wrap( Object o, String name ) {

		Gson gson = new Gson();
		String json = gson.toJson(o);
		
		json = "{\""+name+"\":"+json+"}";
		
		return json;
	}
	
}