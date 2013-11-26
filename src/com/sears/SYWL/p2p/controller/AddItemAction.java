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
		String entryData = "{'storeId':8,'orders':[{'orderName':'chicken','count':14,'preTaxPrice':0.0,'tax':1.0,'totalPrice':0.0}]}";
		
		//hard code user id
		int user_id = 1;
		session.setAttribute("user_id", user_id);
		
		
		
		User user = Controller.api.getUserDao().loadUserById(user_id);
		
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
		
		System.out.println("qunidagedexiezi "+newEntry.getEntryId());
		
		session.setAttribute("my_entry_id", newEntry.getEntryId());
		
		return ("chooseMethod.jsp");
	}
	
}
