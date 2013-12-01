package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.SummaryEntry;

public class ChooseAfFailDeliverAction extends Action {
	public String ACTION_NAME="chooseAfFailDeliverAction.do";

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
		String message = "";
	
		if(request.getParameter("yes") != null) {
			message = "You confirmed to pick up!";
			e.setDeliverMethod(SummaryEntry.PICK_UP);	
			//save the change of method into the database
			Controller.api.getSummaryEntryDao().save(e);

		}
		else {
			message = "You decided not to buy this item!";
		}
		request.setAttribute("message",message);
		
		return "getDeliverFailNext.jsp";
	}

}
