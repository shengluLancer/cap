package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.twilio.sdk.TwilioRestException;

public class SendMessageAction extends Action {

	
	public String ACTION_NAME="sendMessage.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}
	
	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		int summaryentry_id = Integer.parseInt(request.getParameter("entry_id"));
		
		int intent_id = Integer.parseInt(request.getParameter("intent_id"));
		
		try{
			Controller.api.sendMessage(summaryentry_id, intent_id);
		}
		catch(Exception e) {
			System.out.println("Something wrong with SMS function!");
		}
		
		return "na";
		
	}
	
}
