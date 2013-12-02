package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.apiobj.IJSONable;

public class RegisterDeliverIntentAction extends Action {

	@Override
	public String getName() {
		return "registerintent.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
		
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		int capacity=Integer.parseInt(request.getParameter("capacity"));
		long date=Long.parseLong(request.getParameter("date"));
		double lat_dest=Double.parseDouble(request.getParameter("lat_dest"));
		double lng_dest=Double.parseDouble(request.getParameter("lng_dest"));
		String address=request.getParameter("address");
		int store_id=Integer.parseInt(request.getParameter("store_id"));
		int reward=Integer.parseInt(request.getParameter("reward"));
		int entry_id=Integer.parseInt(request.getParameter("entry_id"));
		
		IJSONable returnMessage=Controller.api.registerDeliveryIntent(user_id, capacity, date, lat_dest, 
				lng_dest, address, store_id, reward, entry_id);
		writer.write(returnMessage.toJSON());
		
		return "out";
	}

}
