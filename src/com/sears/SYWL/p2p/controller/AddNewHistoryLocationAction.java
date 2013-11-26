package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.apiobj.IJSONable;

public class AddNewHistoryLocationAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "addhisloc.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		
		String address=request.getParameter("address");
		double latitude=Double.parseDouble(request.getParameter("latitude"));
		double longitude=Double.parseDouble(request.getParameter("longitude"));
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		boolean deliver=Boolean.parseBoolean(request.getParameter("deliver"));
		
		IJSONable returnMessage=Controller.api.addNewHistoryLocation(address, latitude, longitude, user_id, deliver);
		
		writer.write(returnMessage.toJSON());
		
		return "out";
	}

}
