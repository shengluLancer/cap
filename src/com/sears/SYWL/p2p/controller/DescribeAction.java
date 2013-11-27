package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.SummaryEntry;

public class DescribeAction extends Action {
	
	public String ACTION_NAME="describe.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		HttpSession session = request.getSession();
		int user_id = (Integer)session.getAttribute("user_id");
		
		String address = (String)request.getParameter("finalAddress");
		double lat_dest = Double.parseDouble((String)request.getParameter("finalLatitude"));
		double lng_dest = Double.parseDouble((String)request.getParameter("finalLongitude"));
		
		
		String description = (String)request.getParameter("description");
		int capacity =  Integer.parseInt((String)request.getParameter("amount"));
		
		int entry_id = Integer.parseInt((String)request.getParameter("entry_id"));
		SummaryEntry entry = Controller.api.getSummaryEntryDao().loadSummaryEntryById(entry_id);
		
		Controller.api.registerDeliveryIntent(user_id, capacity, System.currentTimeMillis(),
				lat_dest, lng_dest, address,entry.getStoreId() , 10);
		
        return("summary.jsp");	
	}

}