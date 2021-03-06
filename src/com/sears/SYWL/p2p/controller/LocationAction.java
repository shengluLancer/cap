package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.SummaryEntry;

public class LocationAction extends Action {
	
	public String ACTION_NAME="locationAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		String mode = request.getParameter("out_mode");
		HttpSession session = request.getSession();
		int userId = new Integer((session).getAttribute("user_id").toString());
		

		String confirmAddr = request.getParameter("confirmAddr");
		double confirmLongitude = new Double(request.getParameter("confirmLongitude"));
		double confirmLatitude = new Double(request.getParameter("confirmLatitude"));
		
        request.setAttribute("address", confirmAddr);
        request.setAttribute("latitude", confirmLatitude);
        request.setAttribute("longitude", confirmLongitude);
        
		
		
		if( mode.equals("0") ) {			
			// get delivery	
	        return ("getDeliverLoc.jsp");
		}
		else{
	        // pick up self
	        // connect to xiaoyu's page
			
			
			return  "editDetails.jsp";
		}
        
        
	}

}
