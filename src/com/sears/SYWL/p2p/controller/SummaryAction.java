package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.apiobj.IJSONable;
import com.sears.SYWL.p2p.dal.Summary;

public class SummaryAction extends Action {
	
	public String ACTION_NAME="summary.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		Summary summary=(Summary)request.getSession().getAttribute("my_summary");
		IJSONable returnMessage=Controller.api.confirmSummary(summary);
		
		HttpSession session = request.getSession();
		Boolean f = (Boolean) session.getAttribute("flag");
		
		if(f)
			return "sendMessage.jsp";
		else
			return "SMS.jsp";
	}

}