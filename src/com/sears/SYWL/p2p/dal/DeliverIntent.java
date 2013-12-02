package com.sears.SYWL.p2p.dal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "TB_DELIVER_INTENT")
public class DeliverIntent {
	@Id
	@GeneratedValue
	@Column(name="DELIVER_ID")
	private int deliverId;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name="TB_DELIVER_USER", joinColumns = @JoinColumn(name="DELIEVER_ID"),
			inverseJoinColumns = @JoinColumn(name="USER_ID"))
	private User user;
	
	@Column(name="CAPACITY")
	private int capacity;
	@Column(name="DATE")
	private long date;
	@Column(name="LATITUDE")
	private double latitude;
	@Column(name="LONGITUDE")
	private double longitude;
	@Column(name="REWARD")
	private int reward;
	@Column(name="STORE_ID")
	private int store_id;
	@Column(name="DUE_TIME")
	private long due_time;
	@Column(name="ACTIVE")
	private int active;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="TB_DELIVER_PICKUP_USER", joinColumns = @JoinColumn(name="DELIEVER_ID"),
			inverseJoinColumns = @JoinColumn(name="USER_ID"))
	private Set<User> pickupUsers;
	
	public Set<User> getPickupUsers() {
		if(pickupUsers == null){
			pickupUsers = new HashSet<User>();
		}
		return pickupUsers;
	}
	public void setPickupUsers(Set<User> pickupUsers) {
		this.pickupUsers = pickupUsers;
	}
	/*
	public DeliverIntent(){}
	public DeliverIntent(DeliverIntent intent){
		this.active = intent.active;
		this.due_time = intent.due_time;
		this.store_id = intent.store_id;
		this.reward = intent.reward;
		this.latitude = intent.latitude;
		this.longitude = intent.longitude;
		this.date = intent.date;
		this.capacity = intent.capacity;
		this.user = intent.user;
		this.deliverId = intent.deliverId;
	}
	*/
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public long getDue_time() {
		return due_time;
	}
	public void setDue_time(long due_time) {
		this.due_time = due_time;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
	public int getDeliverId() {
		return deliverId;
	}
	
	public void setDeliverId(int deliverId) {
		this.deliverId = deliverId;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getReward() {
		return reward;
	}
	
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {		
		this.user = user;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
