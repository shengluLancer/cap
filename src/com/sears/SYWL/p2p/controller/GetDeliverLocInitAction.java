package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetDeliverLocInitAction extends Action {
	
	public String ACTION_NAME="getDeliverLocInitAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		HttpSession session = request.getSession(true);
		int userId = new Integer((session).getAttribute("userId").toString());
//		String addressJason = getLocationHistory(userId);
//		String addressJson = 
//			"{" +
//				"'LocationHistory':{" +
//				        "'userId':1," +
//						"'locations':[" +
//						    "{'locationId':0," +
//						    "'address':'5030 Centre Ave, Pittsburgh'," +
//						    "'latitude':-79.94392949999997," +
//						    "'longitude':40.4443411" +
//						    "}," + 
//						    "{'locationId':1," +
//						    "'address':'50 Market Street, San Francisco, CA 94105, USA'," +
//						    "'latitude':-122.39520160000001," +
//						    "'longitude':37.794434" +
//						    "}" +
//						"]" +
//				"}" +
//	        "}";
//		String addressJson = "{" +
//				"\"LocationHistory\":" +
//				"{\"locationId\":0," +
//			    "\"address\":\"5030 Centre Ave, Pittsburgh\"}}}";
		String addressJson="{\"location\":\"pitts\"}";
		System.out.println(addressJson);
		request.setAttribute("locationHistory", addressJson);
        return ("map.jsp");
	}

}
