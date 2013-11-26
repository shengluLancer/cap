package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.apiobj.IJSONable;

public class ActivateIntentAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "activateintent.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		
		int intent_id=Integer.parseInt(request.getParameter("intent_id"));
		
		IJSONable returnMessage=Controller.api.activateDeliveryIntent(intent_id);
		writer.write(returnMessage.toJSON());
		
		return "out";
	}

}
