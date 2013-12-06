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


public class AddItemAction extends Action {
	public String ACTION_NAME="addItemAction.do";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ACTION_NAME;
	}
	
	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {	
		
		
		HttpSession session = request.getSession();
		
		// hard code Summary Entry
		int entry_data_number = (Integer)session.getAttribute("entry_data_number");
		String entryData;
		if( entry_data_number == 1 ) {
			 entryData = "{'storeId':1,'orders':[{'orderName':'Beef Burger','count':1,'preTaxPrice':7.6,'tax':1.0,'totalPrice':8.6}]}";
		}
		else if(entry_data_number == 2) {
			 entryData = "{'storeId':2,'orders':[{'orderName':'Mocha','count':2,'preTaxPrice':3.4,'tax':0.5,'totalPrice':3.9}]}";
		}
		else {
			// 3
			 entryData = "{'storeId':3,'orders':[{'orderName':'Bubble Tea','count':3,'preTaxPrice':12.4,'tax':2.0,'totalPrice':14.4}]}";
		}
			
		//----------------------------------------
		//hard code user id
		//need to be removed
		//----------------------------------------
//		int user_id = 1;
//		session.setAttribute("user_id", user_id);
		int user_id = (Integer)session.getAttribute("user_id");
		
		System.out.println("GEETETETETTuerid:"+user_id);
		
		
		User user = Controller.api.getUserDao().loadUserById((Integer)session.getAttribute("user_id"));
		
		SummaryEntry newEntry = (SummaryEntry)JsonWrapper.unwrap(entryData, SummaryEntry.class);

		Summary ss;
		
		// if first summary entry
		if( session.getAttribute( "my_summary" ) == null ) {
			ss = new Summary();
			session.setAttribute("my_summary", ss);
		}
		else {
			ss = (Summary)session.getAttribute("my_summary");
		}
		
		Set<SummaryEntry> temp = ss.getEntryList();
		if( temp==null ) {
			temp = new HashSet<SummaryEntry>();
		}
		
		temp.add(newEntry);
		ss.setEntryList(temp);
		ss.setUser(user);
		
		Controller.api.getSummaryDao().save(ss);
		
		session.setAttribute("my_entry_id", newEntry.getEntryId());
		
		return ("chooseMethod.jsp");
	}
	
}
