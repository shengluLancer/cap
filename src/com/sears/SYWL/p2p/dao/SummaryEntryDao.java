package com.sears.SYWL.p2p.dao;

import com.sears.SYWL.p2p.dal.*;

public interface SummaryEntryDao extends GenericDao<SummaryEntry> {
	public SummaryEntry loadSummaryEntryById(int summaryEntry_id);
}
