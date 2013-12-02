package com.sears.SYWL.p2p.controller;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.apiobj.JsonWrapper;
import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.SummaryEntry;
import com.sears.SYWL.p2p.dal.User;


public class WelcomeAction extends Action {
	public String ACTION_NAME="welcomeAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}
	
	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		
		HttpSession session = request.getSession();
		
		
		//hard code user id
		int user_id = 1;
		session.setAttribute("user_id", user_id);
		
		User user = Controller.api.getUserDao().loadUserById(user_id);
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = "+1" + request.getParameter("phoneNum1") + request.getParameter("phoneNum2") + request.getParameter("phoneNum3");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(phoneNumber);
		

		return ("addItem.jsp");
	}
	
}
