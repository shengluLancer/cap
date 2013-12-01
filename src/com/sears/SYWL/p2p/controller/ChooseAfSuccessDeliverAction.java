package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.SummaryEntry;

public class ChooseAfSuccessDeliverAction extends Action {
	public String ACTION_NAME="chooseAfSuccessDeliverAction.do";

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
	
		if(request.getParameter("checkout") != null) {
			return ("summary.jsp");
		}
		else {
			return ("addItem.jsp");
		}
		
	}

}
