package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LocationAction extends Action {
	
	public String ACTION_NAME="locationAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		HttpSession session = request.getSession(true);
		int userId = new Integer((session).getAttribute("userId").toString());
		String confirmAddr = request.getParameter("confirmAddr");
		double confirmLongitude = new Double(request.getParameter("confirmLongitude"));
		double confirmLatitude = new Double(request.getParameter("confirmLatitude"));
		System.out.println(confirmAddr);
		System.out.println(confirmLatitude);
		System.out.println(confirmLongitude);
//		request.setAttribute("userId", userId);
        request.setAttribute("address", confirmAddr);
        request.setAttribute("latitude", confirmLatitude);
        request.setAttribute("longitude", confirmLongitude);
        return ("getDeliverLocAf.jsp");
	}

}
