package com.sears.SYWL.p2p.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sears.SYWL.p2p.dal.Location;
import com.sears.SYWL.p2p.dal.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	
	public User loadUserById(int userId){
		 User t = new User();
		 User result = new User();
		 Session hibernateSession = this.getSession();
		 System.out.println(hibernateSession);
	     HibernateUtil.beginTransaction();	 
	     t = (User)hibernateSession.load(t.getClass(), userId);
	     result.setbDay(t.getbDay());
	     HibernateUtil.commitTransaction();
	     return t;
	}
	
	public List<Location> getDeliveryHistoryLocation(int userId){
		List<Location> result = new ArrayList<Location>();
		String sql = "select TB_LOCATION.LOCATION_ID from TB_LOCATION join TB_USER_DELIVER_LOCATION USING (LOCATION_ID) where TB_USER_DELIVER_LOCATION.USER_ID = " + userId + " ORDER BY TIMESTAMP DESC";
		Session hibernateSession = this.getSession();
	    HibernateUtil.beginTransaction();
		Query query = hibernateSession.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Integer> idList = query.list();
		System.out.println(idList);
		for(Integer id : idList){
			Location l = new Location();
			l = (Location)hibernateSession.load(l.getClass(), id);
			result.add(l);
		}
		
		HibernateUtil.commitTransaction();
		return result;
		
	}
	
	public List<Location> getBuyerHistoryLocation(int userId){
		List<Location> result = new ArrayList<Location>();
		String sql = "select TB_LOCATION.LOCATION_ID from TB_LOCATION join TB_USER_BUYER_LOCATION USING (LOCATION_ID) where TB_USER_BUYER_LOCATION.USER_ID = " + userId + " ORDER BY TIMESTAMP DESC";
		Session hibernateSession = this.getSession();
		HibernateUtil.beginTransaction();
		Query query = hibernateSession.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Integer> idList = query.list();
		for(Integer id : idList){
			Location l = new Location();
			l = (Location)hibernateSession.load(l.getClass(), id);
			result.add(l);
		}
	
		HibernateUtil.commitTransaction();
		return result;
		
	}
	
	public void updateDeliveryLocationHistory(int userId, double lat, double lng, String address){
		List<Location> resultLocation = getDeliveryHistoryLocation(userId);
		User user = loadUserById(userId);
		Location availableLocation = findAvailableLocation(lat, lng, resultLocation);
		LocationDao locationDao = new LocationDaoImpl();
		if(availableLocation != null){
			availableLocation.setTimestamp(System.currentTimeMillis());
			locationDao.save(availableLocation);
		}
		else{
			Location location = new Location();
			location.setLatitude(lat);
			location.setLongitude(lng);
			location.setAddress(address);
			location.setTimestamp(System.currentTimeMillis());
			user.getDeliverLocationHistory().add(location);
			super.save(user);
		}
	}
	
	
	public void updateBuyerLocationHistory(int userId, double lat, double lng, String address){
		List<Location> resultLocation = getBuyerHistoryLocation(userId);
		User user = loadUserById(userId);
		Location availableLocation = findAvailableLocation(lat, lng, resultLocation);
		LocationDao locationDao = new LocationDaoImpl();
		if(availableLocation != null){
			availableLocation.setTimestamp(System.currentTimeMillis());
			locationDao.save(availableLocation);
		}
		else{
			Location location = new Location();
			location.setLatitude(lat);
			location.setLongitude(lng);
			location.setAddress(address);
			location.setTimestamp(System.currentTimeMillis());
			user.getBuyerLocationHistory().add(location);
			super.save(user);
		}
	}
	
	private Location findAvailableLocation(double lat, double lng, List<Location> resultLocation){
		for(Location location : resultLocation){
			if(location.getLatitude() == lat && location.getLongitude() == lng){
				return location;
			}
		}
		return null;
	}
}
