package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.api.P2PAPI;
import com.sears.SYWL.p2p.api.P2PAPIImpl;
import com.sears.SYWL.p2p.apiobj.IJSONable;

public class CheckAvailabilityAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "checkavailability.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
	
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		double lat_dest=Double.parseDouble(request.getParameter("lat_dest"));
		double lng_dest=Double.parseDouble(request.getParameter("lng_dest"));
		String address=request.getParameter("address");
		int store_id=Integer.parseInt(request.getParameter("store_id"));
		int numOfGoods=Integer.parseInt(request.getParameter("numOfGoods"));
		double pickUpRange=Double.parseDouble(request.getParameter("pickUpRange"));
		long orderDate=Long.parseLong(request.getParameter("orderDate"));
		long dueTime=Long.parseLong(request.getParameter("dueTime"));
		
		IJSONable returnMessage=Controller.api.checkDeliveryAvailability(user_id, lat_dest, lng_dest, address, store_id, numOfGoods, pickUpRange, orderDate, dueTime);
		writer.write(returnMessage.toJSON());
		
		return "out";
	}

}
