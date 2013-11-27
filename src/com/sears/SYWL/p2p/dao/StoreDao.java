package com.sears.SYWL.p2p.dao;

import com.sears.SYWL.p2p.dal.Store;

public interface StoreDao extends GenericDao<Store>{
	public Store loadStoreById(int store_id);
	public String loadNameById(int store_id);
}
