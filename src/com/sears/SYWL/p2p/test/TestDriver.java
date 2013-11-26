package com.sears.SYWL.p2p.test;

import com.sears.SYWL.p2p.dal.*;
import com.sears.SYWL.p2p.dao.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class TestDriver {

	public static List<User> userList = new ArrayList<User>();
	public static List<Location> locationList = new ArrayList<Location>();
	public static List<Order> orderList = new ArrayList<Order>();
	public static List<Summary> summaryList = new ArrayList<Summary>();
	public static List<SummaryEntry> summaryEntryList = new ArrayList<SummaryEntry>();
	public static List<DeliverIntent> intentList = new ArrayList<DeliverIntent>();
	
	
	
	public static void main(String[] args){
		
		//generateExisting();

		generateNone();
	
	}
	
	private static void generateNone(){
		GenerateUser GU = new GenerateUser();
		GenerateLocation GL = new GenerateLocation();
		GenerateOrder GO = new GenerateOrder();
		GenerateSummaryEntry GS = new GenerateSummaryEntry();
		GenerateIntent GI = new GenerateIntent();
		GenerateSummary GSY = new GenerateSummary();
		GU.generate();
		GO.generate();
		GL.generate();
		GS.generate();
		GI.generate();
		GSY.generate();
		
		
		OrderDao orderDao = new OrderDaoImpl();
		for(Order order : orderList)
		    orderDao.save(order);
		Order order1 = orderDao.loadOrderById(1);
		Order order2 = orderDao.loadOrderById(2);
		System.out.println(order1.getTotalPrice());
		
		LocationDao locationDao = new LocationDaoImpl();
		for(Location location : locationList){
			locationDao.save(location);
		}
		Location location1 = locationDao.loadLocationById(1);
		Location location2 = locationDao.loadLocationById(2);
		Location location3 = locationDao.loadLocationById(3);
		System.out.println(location1.getAddress());
		
		
		UserDao userDao = new UserDaoImpl();
		int i = 0;
		for(User user : userList){
			Set<Location> locationList = new HashSet<Location>();
			Set<Location> locationList2 = new HashSet<Location>();
			if(i == 0){
			  locationList.add(location1); 
			}
			if(i == 1){
			  locationList.add(location2);
			  locationList2.add(location3);
			}
			user.setBuyerLocationHistory(locationList);
			user.setDeliverLocationHistory(locationList2);
			userDao.save(user);
			i ++;
		}
		
		User user = new User();
		user.setBuyerLocationHistory(new HashSet<Location>());
		Location lo = new Location();
		Location lo1 = new Location();
		lo.setAddress("tibet");
		lo1.setAddress("bashu middle school");
		user.getBuyerLocationHistory().add(lo);
		user.getBuyerLocationHistory().add(lo1);
		userDao.save(user);
		locationDao.save(locationList.get(1));
				
		User user1 = userDao.loadUserById(1);
		User user2 = userDao.loadUserById(3);
		for(Location l : user2.getBuyerLocationHistory())
		System.out.println(user2.getbDay() + " : " + l.getAddress() + " momoamoamoamoamoamoa");
		
		DeliverIntentDao intentDao = new DeliverIntentDaoImpl();
		intentList.get(0).setUser(user1);
		intentList.get(1).setUser(user2);
		intentDao.save(intentList.get(0));
		intentDao.save(intentList.get(1));		
		
		
		SummaryEntryDao summaryEntryDao = new SummaryEntryDaoImpl();
		summaryEntryList.get(0).setOrders(new HashSet<Order>());
		summaryEntryList.get(0).getOrders().add(order1);
		summaryEntryList.get(0).getOrders().add(orderList.get(2));
		summaryEntryList.get(0).setDeliverLocation(location1);
		summaryEntryList.get(1).setOrders(new HashSet<Order>());
		summaryEntryList.get(1).getOrders().add(order2);
		summaryEntryList.get(1).setDeliverLocation(location2);
		//summaryEntryList.get(1).getOrders().add();
		summaryEntryDao.save(summaryEntryList.get(0));
		summaryEntryDao.save(summaryEntryList.get(1));
		SummaryEntry summaryEntry0 = summaryEntryDao.loadSummaryEntryById(1);
		SummaryEntry summaryEntry1 = summaryEntryDao.loadSummaryEntryById(2);
		System.out.println(summaryEntry1.getDeliverMethod());
		
		
		SummaryDao summaryDao = new SummaryDaoImpl();
		Summary summary0 = summaryList.get(0);
		summary0.setEntryList(new HashSet<SummaryEntry>());
		summary0.getEntryList().add(summaryEntry0);
		summary0.getEntryList().add(summaryEntry1);
		summary0.setUser(user1);
		summaryDao.save(summary0);
		
		Summary summary1 = summaryList.get(1);	
		summary1.setEntryList(new HashSet<SummaryEntry>());
		summary1.getEntryList().add(summaryEntryList.get(2));
		summary1.setUser(user2);
		summaryDao.save(summary1);
		
		DeliverIntent intent1 = intentDao.loadIntentById(1);
		System.out.println(intent1.getCapacity());
		
		List<DeliverIntent> set = intentDao.queryActiveIntentPool(9,System.currentTimeMillis() + 100000000);
		System.out.println(set.size());
		for(DeliverIntent intent: set){
			System.out.println(intent.getDue_time());
		}
		userDao.updateDeliveryLocationHistory(1, 0, 0, "Xi Nan Hai");	
		userDao.updateBuyerLocationHistory(1, 3, 4, "chongqing");
		userDao.updateBuyerLocationHistory(1, 103, 214, "sichuan");
		userDao.updateBuyerLocationHistory(1, 241, 400, "manchester");
		
		Summary summary = summaryDao.loadSummaryById(1);
		for(SummaryEntry se : summary.getEntryList())
			System.out.println(se.getDeliverMethod());
	
		/*
		summary.getEntryList().remove(summaryEntry0);
		summaryDao.save(summary);	
		
		Summary deletedSummary = summaryDao.loadSummaryById(1);
		System.out.println(deletedSummary.getEntryList());
		*/
	}
}
