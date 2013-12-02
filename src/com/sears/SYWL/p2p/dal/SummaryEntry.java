package com.sears.SYWL.p2p.dal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "SUMMARY_ENTRY")
public class SummaryEntry {

	public static final String PICK_UP = "pickup";
	public static final String GET_DELIVERY = "delivered";
	
	@Id
	@GeneratedValue
	@Column(name="ENTRY_ID")
	private int entryId;
	
	@Column(name="STORE_ID")
	private int storeId;
	@Column(name="DELIVER_METHOD")
	private String deliverMethod;
	
	@OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL})
	@JoinTable(name="TB_ENTRY_ORDER", 
	 	  	   joinColumns={@JoinColumn(name="ENTRY_ID")},
	 	  	   inverseJoinColumns={@JoinColumn(name="ORDER_ID")})
	private Set<Order> orders;
	
	@Column(name="DELIVER_TIME")
	private long deliverTime;
	 
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name="TB_ENTRY_LOCATION", 
			   joinColumns = @JoinColumn(name="ENTRY_ID"),
			   inverseJoinColumns = @JoinColumn(name="LOCATION_ID"))
	private Location deliverLocation;
	 
	@Column(name="DETAILED_DESCRIPTION")
	private String detailedDescription;
	@Column(name="MAX_DELIVER")
	private int maxDeliverCount;
	@Column(name="MAX_POINTS")
	private int maxPoints;
	@Column(name="SUBTOTAL")
	private double subtotalPrice;
	@Column(name="DELIVER_FEE")
	private double deliverFee;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinTable(name="TB_ENTRY_INTENT", 
			   joinColumns = @JoinColumn(name="ENTRY_ID"),
			   inverseJoinColumns = @JoinColumn(name="DELIVER_ID"))
	private DeliverIntent deliverIntent;

	
	public DeliverIntent getDeliverIntent() {
		return deliverIntent;
	}
	public void setDeliverIntent(DeliverIntent deliverIntent) {
		this.deliverIntent = deliverIntent;
	}
	public static String getPickUp() {
		return PICK_UP;
	}
	public static String getGetDelivery() {
		return GET_DELIVERY;
	}
	public int getEntryId() {
		return entryId;
	}
	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getDeliverMethod() {
		return deliverMethod;
	}
	public void setDeliverMethod(String deliverMethod) {
		this.deliverMethod = deliverMethod;
	}
	public Set<Order> getOrders() {
		if(orders == null){
			orders = new HashSet<Order>();
		}
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public long getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(long deliverTime) {
		this.deliverTime = deliverTime;
	}
	public Location getDeliverLocation() {
		return deliverLocation;
	}
	public void setDeliverLocation(Location deliverLocation) {
		this.deliverLocation = deliverLocation;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public int getMaxDeliverCount() {
		return maxDeliverCount;
	}
	public void setMaxDeliverCount(int maxDeliverCount) {
		this.maxDeliverCount = maxDeliverCount;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	public double getSubtotalPrice() {
		return subtotalPrice;
	}
	public void setSubtotalPrice(double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}
	public double getDeliverFee() {
		return deliverFee;
	}
	public void setDeliverFee(double deliverFee) {
		this.deliverFee = deliverFee;
	}
	
}
