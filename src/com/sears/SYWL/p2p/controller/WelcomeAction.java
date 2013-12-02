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
		
		
//		//hard code user id
//		int user_id = 1;
//		session.setAttribute("user_id", user_id);
		
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = "+1" + request.getParameter("phoneNum1") + request.getParameter("phoneNum2") + request.getParameter("phoneNum3");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(phoneNumber);
		System.out.println(System.currentTimeMillis());
		
		//create a new user
		User user = new User();
		user.setfName(firstName);
		user.setlName(lastName);
		user.setPhoneNumber(phoneNumber);
		Controller.api.getUserDao().save(user);
		
		int user_id = user.getUserId();
		
		System.out.println("!!!!!!!!user_id:"+user_id);
		
		session.setAttribute("user_id", user_id);
		
		return ("addItem.jsp");
	}
	
}
