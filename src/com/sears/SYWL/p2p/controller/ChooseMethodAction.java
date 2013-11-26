package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseMethodAction extends Action {
	public String ACTION_NAME="chooseMethodAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}
	
	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		if(request.getParameter("getDelivered") != null) {
	        return ("getDeliverLoc.jsp");
		}
		else {
			return ("getDeliverLoc.jsp");
		}
	}

}
