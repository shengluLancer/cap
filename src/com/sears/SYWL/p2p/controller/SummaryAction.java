package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		return "sendMessage.jsp";
	}

}