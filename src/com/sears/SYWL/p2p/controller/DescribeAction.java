package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DescribeAction extends Action {
	
	public String ACTION_NAME="describe.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		String address = (String)request.getParameter("address");
		String description = (String)request.getParameter("description");
		String amount = (String)request.getParameter("amount");
		
		if(address==null || description==null || amount==null ||
				address.isEmpty() || description.isEmpty() || amount.isEmpty()){
			request.setAttribute("error", "true");
			return("summary.jsp");
		}
            return("success.jsp");	
	}

}