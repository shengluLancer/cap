package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeliveryConfirmAction extends Action {
	
	public String ACTION_NAME="deliveryConfirmAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		
		
		HttpSession session = request.getSession(true);
		int userId = new Integer((session).getAttribute("userId").toString());
		String longitude = request.getParameter("finalLongitude");
		String latitude = request.getParameter("finalLatitude");
//		double latitude = new Double(request.getParameter("finalLatitude"));
//		double longitude = new Double(request.getParameter("finalLongitude"));
		String address = request.getParameter("finalAddress");
		double range = new Double(request.getParameter("range"));
		
		System.out.println("Entering   DeliveryConfirmAction.java");
		System.out.println(userId);
		System.out.println(latitude);
		System.out.println(longitude);
		System.out.println(address);
		System.out.println(range);
		
		
		if(Math.random() > 0.5) return ("getDeliverSuccess.jsp");
		else return ("getDeliverFail.jsp");
	}

}
