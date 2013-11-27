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
		
		//tell maps.jsp that the reason of calling it     (pick up or get delivery)
		// mode 0 : get delivery
		// mode 1 : pick up by self
		int mode = new Integer(request.getParameter("mode"));
		request.setAttribute("mode", mode);
        return ("map.jsp");
	}

}
