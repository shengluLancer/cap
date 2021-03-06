package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sears.SYWL.p2p.apiobj.CheckIntentMessage;
import com.sears.SYWL.p2p.dal.Location;
import com.sears.SYWL.p2p.dal.SummaryEntry;

public class DeliveryConfirmAction extends Action {
	
	public String ACTION_NAME="deliveryConfirmAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		
		
		HttpSession session = request.getSession();
		int userId = new Integer((session).getAttribute("user_id").toString());
		double longitude = Double.parseDouble(request.getParameter("finalLongitude"));
		double latitude = Double.parseDouble(request.getParameter("finalLatitude"));
		String address = request.getParameter("finalAddress");
		double range = new Double(request.getParameter("range"));
		
		
		//check availability
		int my_entry_id = (Integer)session.getAttribute("my_entry_id");
		SummaryEntry e = Controller.api.getSummaryEntryDao().loadSummaryEntryById(my_entry_id);
        String json = Controller.api.checkDeliveryAvailability(userId, latitude, longitude, address, 
        		e.getStoreId(), e.getOrders().size(), range, System.currentTimeMillis(), System.currentTimeMillis()+2*60*60*1000).toJSON();
        
        Location l = new Location();
        
        l.setAddress(address);
        l.setLatitude(latitude);
        l.setLongitude(longitude);
        
        e.setDeliverLocation(l);
        Controller.api.getSummaryEntryDao().save(e);
        
		Gson gson=new Gson();
		
		CheckIntentMessage intentMessage=gson.fromJson(json, CheckIntentMessage.class);
		
		session.setAttribute("holding_list", intentMessage.getIntentList());
		
		if(intentMessage.getAvailability()) {
			return "getDeliverSuccess.jsp";
		}
		else {
			return "getDeliverFail.jsp";
		}

	}

}
