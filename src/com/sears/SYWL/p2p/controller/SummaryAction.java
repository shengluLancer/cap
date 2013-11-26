package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SummaryAction extends Action {
	
	public String ACTION_NAME="summary.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		if(request.getParameter("viewDetails") != null)
		{
            return("viewDetails.jsp");	
		}
		else
		{
			String status = (String) request.getParameter("status");
			
			if(status.equals("delivered"))
			{
	            return("success.jsp");	
			}
			else
			{
				String deliverForOthers = (String)request.getParameter("delivertype");
		
				if(deliverForOthers.equals("forOthers"))
				{
		            return("editDetails.jsp");	
				}
				else
				{
		            return("success.jsp");	
				}
			}
		}
	}

}