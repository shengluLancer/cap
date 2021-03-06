package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.Location;
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
		
		String description = (String)request.getParameter("description");
		String amount = (String)request.getParameter("amount");
		System.out.println("aaa");
		if(description==null || amount==null || description==null || amount==null ||
				description.isEmpty() || amount.isEmpty() || description.isEmpty() || amount.isEmpty()){
			System.out.println("bbb");
			request.setAttribute("error", 1);
			return("editDetails.jsp");
		}
		
		String address = (String)request.getParameter("finalAddress");
		double lat_dest = Double.parseDouble((String)request.getParameter("finalLatitude"));
		double lng_dest = Double.parseDouble((String)request.getParameter("finalLongitude"));
		
		int capacity =  Integer.parseInt((String)request.getParameter("amount"));
		int entry_id = Integer.parseInt((String)request.getParameter("entry_id"));
		SummaryEntry entry = Controller.api.getSummaryEntryDao().loadSummaryEntryById(entry_id);
		
		Controller.api.registerDeliveryIntent(user_id, capacity, System.currentTimeMillis(),
				lat_dest, lng_dest, address,entry.getStoreId(), 10, description, entry.getEntryId());
		
		Location location = new Location();
		location.setAddress(address);
		location.setLatitude(lat_dest);
		location.setLongitude(lng_dest);
		entry.setDeliverLocation(location);
		Controller.api.getSummaryEntryDao().save(entry);
		
        return("summary.jsp");	
	}

}