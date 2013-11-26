package com.sears.SYWL.p2p.dao;

import com.sears.SYWL.p2p.dal.*;

public interface LocationDao extends GenericDao<Location>{
		public Location loadLocationById(int location_id);
}
