package com.sears.SYWL.p2p.dao;

import com.sears.SYWL.p2p.dal.*;

public interface SummaryDao extends GenericDao<Summary> {
	public Summary loadSummaryById( int summary_id );
}
