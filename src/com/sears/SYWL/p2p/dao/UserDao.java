package com.sears.SYWL.p2p.dao;

import java.util.List;

import com.sears.SYWL.p2p.dal.*;

public interface UserDao extends GenericDao<User>{

	public User loadUserById(int userId);
	public List<Location> getDeliveryHistoryLocation(int userId);
	public List<Location> getBuyerHistoryLocation(int userId);
	public void updateDeliveryLocationHistory(int userId, double lat, double lng, String address);
	public void updateBuyerLocationHistory(int userId, double lat, double lng, String address);
}
