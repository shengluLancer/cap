package com.sears.SYWL.p2p.dao;

import java.util.List;
import java.util.Set;

import com.sears.SYWL.p2p.dal.*;



public interface DeliverIntentDao extends GenericDao<DeliverIntent>{
	   
		 public DeliverIntent loadIntentById(int intentId);
		 public List<DeliverIntent> queryActiveIntentPool(int store_id,  long dueTime);
		 public boolean deleteIntentById(int intentID);
}
