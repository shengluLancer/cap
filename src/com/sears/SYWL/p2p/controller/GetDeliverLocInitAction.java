package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetDeliverLocInitAction extends Action {
	
	public String ACTION_NAME="getDeliverLocInitAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		HttpSession session = request.getSession();
		int user_id = (Integer)session.getAttribute("user_id");
		
		//get history with user id 
		request.setAttribute("user_id", user_id);
		
        return ("map.jsp");
	}

}
