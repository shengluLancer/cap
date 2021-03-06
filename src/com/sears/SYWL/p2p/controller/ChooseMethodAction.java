package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.SummaryEntry;

public class ChooseMethodAction extends Action {
	public String ACTION_NAME="chooseMethodAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}
	
	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		HttpSession session=request.getSession();
		int entry_id = (Integer)session.getAttribute("my_entry_id");
		SummaryEntry e = Controller.api.getSummaryEntryDao().loadSummaryEntryById(entry_id);
	
		if(request.getParameter("getDelivered") != null) {
			e.setDeliverMethod(SummaryEntry.GET_DELIVERY);

			Controller.api.getSummaryEntryDao().save(e);
			return ("getDeliverLoc.jsp");
		}
		else {
			e.setDeliverMethod(SummaryEntry.PICK_UP);

			Controller.api.getSummaryEntryDao().save(e);
			return ("pickupContinueShopping.jsp");
		}
		
	}

}
