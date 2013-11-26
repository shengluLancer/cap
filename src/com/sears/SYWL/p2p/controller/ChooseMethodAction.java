package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.dal.Summary;

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
		Summary summary=(Summary)session.getAttribute("my_summary");
		System.out.println(summary.getSummaryId());
		
		if(request.getParameter("getDelivered") != null) {
	        return ("getDeliverLoc.jsp");
		}
		else {
			return ("getDeliverLoc.jsp");
		}
	}

}
