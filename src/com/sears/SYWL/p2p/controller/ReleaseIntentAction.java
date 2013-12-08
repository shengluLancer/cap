package com.sears.SYWL.p2p.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.sears.SYWL.p2p.api.P2PAPI;
import com.sears.SYWL.p2p.api.P2PAPIImpl;
import com.sears.SYWL.p2p.apiobj.IJSONable;
import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.SummaryEntry;

public class ReleaseIntentAction extends Action{
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "releaseintent.do";
	}

	@Override
	public String perform(HttpServletRequest request, PrintWriter writer) {
	
		Summary summary = (Summary)request.getSession().getAttribute("my_summary");
		Set<SummaryEntry> entryList = summary.getEntryList();
		IJSONable returnMessage = null;
		for(SummaryEntry se : entryList){
			if(se.getDeliverMethod().equals(SummaryEntry.GET_DELIVERY))
				returnMessage = Controller.api.releaseIntent(se.getEntryId(),
						Controller.api.getSummaryEntryDao().getNumOfGoods(se.getEntryId()));
		}
		if(returnMessage != null)
			writer.write(returnMessage.toJSON());
		
		return "welcome.jsp";
	}

}
