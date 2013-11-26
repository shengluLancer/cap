package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.api.P2PAPI;
import com.sears.SYWL.p2p.api.P2PAPIImpl;
import com.sears.SYWL.p2p.apiobj.IJSONable;

public class GetBuyerLocationHistoryAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "getbuyerlochis.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		
		IJSONable returnMessage=Controller.api.getLocationHistoryByUserId_buyer(user_id);
		writer.write(returnMessage.toJSON());
		return "out";
	}

}
