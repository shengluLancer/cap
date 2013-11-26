package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.api.P2PAPI;
import com.sears.SYWL.p2p.api.P2PAPIImpl;
import com.sears.SYWL.p2p.apiobj.IJSONable;

public class ReleaseIntentAction extends Action{
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "releaseintent.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		
		int intent_id=Integer.parseInt(request.getParameter("intent_id"));
		int numOfGoods=Integer.parseInt(request.getParameter("numOfGoods"));
		
		IJSONable returnMessage=Controller.api.releaseIntent(intent_id, numOfGoods);
		
		writer.write(returnMessage.toJSON());
		
		return "out";
	}

}
