package com.sears.SYWL.p2p.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.sears.SYWL.p2p.apiobj.CheckIntentMessage;
import com.sears.SYWL.p2p.apiobj.IJSONable;
import com.sears.SYWL.p2p.apiobj.LocationHistoryMessage;
import com.sears.SYWL.p2p.apiobj.OrderListMessage;
import com.sears.SYWL.p2p.apiobj.SimpleMessage;
import com.sears.SYWL.p2p.dal.DeliverIntent;
import com.sears.SYWL.p2p.dal.Location;
import com.sears.SYWL.p2p.dal.Order;
import com.sears.SYWL.p2p.dal.Summary;
import com.sears.SYWL.p2p.dal.User;
import com.sears.SYWL.p2p.dao.DeliverIntentDao;
import com.sears.SYWL.p2p.dao.DeliverIntentDaoImpl;
import com.sears.SYWL.p2p.dao.LocationDao;
import com.sears.SYWL.p2p.dao.LocationDaoImpl;
import com.sears.SYWL.p2p.dao.OrderDao;
import com.sears.SYWL.p2p.dao.OrderDaoImpl;
import com.sears.SYWL.p2p.dao.StoreDao;
import com.sears.SYWL.p2p.dao.StoreDaoImpl;
import com.sears.SYWL.p2p.dao.SummaryDao;
import com.sears.SYWL.p2p.dao.SummaryDaoImpl;
import com.sears.SYWL.p2p.dao.SummaryEntryDao;
import com.sears.SYWL.p2p.dao.SummaryEntryDaoImpl;
import com.sears.SYWL.p2p.dao.UserDao;
import com.sears.SYWL.p2p.dao.UserDaoImpl;

public class P2PAPIImpl implements P2PAPI {
	
	public DeliverIntentDao deliverIntentDao;
	public UserDao userDao;
	public OrderDao orderDao;
	public SummaryDao summaryDao;
	public SummaryEntryDao summaryEntryDao;
	public LocationDao locationDao;
	public StoreDao storeDao;
	
	private static Comparator<Location> locationComparator= new Comparator<Location>() {

		@Override
		public int compare(Location o1, Location o2) {
			return (int) (o2.getTimestamp()-o1.getTimestamp());
		}
	};
	
	public P2PAPIImpl() {
		deliverIntentDao = new DeliverIntentDaoImpl();
		userDao=new UserDaoImpl();
		orderDao=new OrderDaoImpl();
		summaryDao=new SummaryDaoImpl();
		summaryEntryDao= new SummaryEntryDaoImpl();
		locationDao=new LocationDaoImpl();
		storeDao = new StoreDaoImpl();
	}

	@Override
	public IJSONable checkDeliveryAvailability(int user_id,double lat_dest,
			double lng_dest,String address, int store_id, int numOfGoods, double pickUpRange,
			long orderDate, long dueTime) {
		List<DeliverIntent> intentList=deliverIntentDao.queryActiveIntentPool(store_id, dueTime);
		int leftGoods=numOfGoods;
		ArrayList<Integer> matchedList=new ArrayList<Integer>();
		
		userDao.updateBuyerLocationHistory(user_id, lat_dest, lng_dest, address);
		
		for(DeliverIntent intent:intentList) {
			if(GeographyUtils.distanceOnEarth(lat_dest, lng_dest, intent.getLatitude(), 
					intent.getLongitude())>pickUpRange) {
				continue;
			}
			leftGoods=holdIntent(intent,leftGoods);
			deliverIntentDao.save(intent);
			matchedList.add(intent.getDeliverId());
			if(leftGoods==0) return new CheckIntentMessage(true, matchedList);
		}
		
		return new CheckIntentMessage(false,null);
		
	}

	@Override
	public int holdIntent(DeliverIntent intent, int numOfGoods) {
		
		int capacity=intent.getCapacity();
		if(capacity<numOfGoods) {
			intent.setCapacity(0);
			return numOfGoods-capacity;
		}
		else {
			intent.setCapacity(intent.getCapacity()- numOfGoods);
			return 0;
		}
	}

	@Override
	public IJSONable releaseIntent(int intent_id, int numOfGoods) {
		// TODO Auto-generated method stub
		DeliverIntent intent=deliverIntentDao.loadIntentById(intent_id);
		int capacity=intent.getCapacity();
		if(intent.getCapacity()==0) { //TODO Add this method..
			intent.setCapacity(numOfGoods);
		}
		
		deliverIntentDao.save(intent);
		
		return new SimpleMessage("true");
	}

	@Override
	public IJSONable getLocationHistoryByUserId_buyer(int user_id) {
		User user=userDao.loadUserById(user_id);
		Set<Location> set=user.getBuyerLocationHistory();
		TreeSet<Location> resultSet=new TreeSet<Location>(locationComparator);
		resultSet.addAll(set);
		return new LocationHistoryMessage(resultSet);
	}

	@Override
	public IJSONable postSummary(String jsonfile) {
		// TODO parse the JSON File
		
		return getSummaryPage();
	}

	@Override
	public IJSONable getSummaryPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IJSONable confirmSummary(Summary summary) {
		summaryDao.save(summary);
		
		return new SimpleMessage("true");
	}

	@Override
	public IJSONable registerDeliveryIntent(int user_id, int capacity,
			long date, double lat_dest, double lng_dest, String address, int store_id,
			int reward) {
		DeliverIntent dIntent=new DeliverIntent();
		dIntent.setStore_id(store_id);
		User user =userDao.loadUserById(user_id);
		dIntent.setUser(user);
		dIntent.setCapacity(capacity);
		dIntent.setDate(date);
		dIntent.setDue_time(date+40*60*1000);
		dIntent.setLatitude(lat_dest);
		dIntent.setLongitude(lng_dest);
		dIntent.setReward(reward);
		dIntent.setActive(0);
		
		userDao.updateDeliveryLocationHistory(user_id, lat_dest, lng_dest, address);
		
		deliverIntentDao.save(dIntent);
		return new SimpleMessage("true");
	}

	@Override
	public IJSONable activateDeliveryIntent(int intent_id) {
		DeliverIntent intent=deliverIntentDao.loadIntentById(intent_id);
		intent.setActive(1);
		deliverIntentDao.save(intent);
		return new SimpleMessage("true");
	}

	@Override
	public IJSONable getLocationHistoryByUserId_Deliverer(int user_id) {
		User user=userDao.loadUserById(user_id);
		Set<Location> set=user.getDeliverLocationHistory();
		TreeSet<Location> resultSet=new TreeSet<Location>(locationComparator);
		resultSet.addAll(set);
		return new LocationHistoryMessage(resultSet);
	}

	@Override
	public IJSONable sendOrders(int[] order_ids) {
		ArrayList<Order> list=new ArrayList<Order>(); 
		for(int i=0;i<order_ids.length;i++){
			Order order=orderDao.loadOrderById(order_ids[i]);
			list.add(order);
		}
		
		return new OrderListMessage(list);
	}

	@Override
	public IJSONable confirmPickUp(int intent_id, boolean isSuccess) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public IJSONable addNewHistoryLocation(String address,double latitude, double longitude,int user_id, boolean deliver){
		Location newLocation=new Location();
		newLocation.setAddress(address);
		
		User user=userDao.loadUserById(user_id);
		if(deliver) {
			if(user.getDeliverLocationHistory()==null) {
				user.setDeliverLocationHistory(new HashSet<Location>());
			}
			
			user.getDeliverLocationHistory().add(newLocation);
		}
		else {
			if(user.getBuyerLocationHistory()==null) {
				user.setBuyerLocationHistory(new HashSet<Location>());
			}
			user.getBuyerLocationHistory().add(newLocation);
		}
		
		userDao.save(user);
		
		return new SimpleMessage("true");
		
	}
	
	public SummaryDao getSummaryDao() {
		return this.summaryDao;
	}
	
	public SummaryEntryDao getSummaryEntryDao() {
		return this.summaryEntryDao;
	}

	@Override
	public DeliverIntentDao getDeliverIntentDao() {
		return this.deliverIntentDao;
	}

	@Override
	public UserDao getUserDao() {
		return this.userDao;
	}

	@Override
	public LocationDao getLocationDao() {
		return this.locationDao;
	}

	@Override
	public OrderDao getOrderDao() {
		return this.orderDao;
	}
	
	@Override
	public StoreDao getStoreDao() {
		return this.storeDao;
	}
	

}
