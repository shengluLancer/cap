package com.sears.SYWL.p2p.dal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TB_USER")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="FIRSTNAME")
	private String fName;
	
	@Column(name="LASTNAME")
	private String lName;
	
	@Column(name="PHONE_NUM")
	private String phoneNumber;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="B_Month")
	private String bMonth;
	
	@Column(name="B_DAY")
	private String bDay;
	
	@Column(name="B_YEAR")
	private String bYear;
	
	@Column(name="POINTS")
	private int points;
	
	@OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinTable(name="TB_USER_DELIVER_LOCATION", 
                joinColumns={@JoinColumn(name="USER_ID")}, 
                inverseJoinColumns={@JoinColumn(name="LOCATION_ID")})
	Set<Location> deliverLocationHistory;
	
	@OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinTable(name="TB_USER_BUYER_LOCATION" ,
                joinColumns={@JoinColumn(name="USER_ID")}, 
                inverseJoinColumns={@JoinColumn(name="LOCATION_ID")})
	Set<Location> buyerLocationHistory;
	
	public Set<Location> getDeliverLocationHistory() {
		return deliverLocationHistory;
	}

	public void setDeliverLocationHistory(Set<Location> deliverLocationHistory) {
		this.deliverLocationHistory = deliverLocationHistory;
	}

	public Set<Location> getBuyerLocationHistory() {
		return buyerLocationHistory;
	}

	public void setBuyerLocationHistory(Set<Location> buyerLocationHistory) {
		this.buyerLocationHistory = buyerLocationHistory;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getbMonth() {
		return bMonth;
	}
	
	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}
	
	public String getbDay() {
		return bDay;
	}
	
	public void setbDay(String bDay) {
		this.bDay = bDay;
	}
	
	public String getbYear() {
		return bYear;
	}
	
	public void setbYear(String bYear) {
		this.bYear = bYear;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	

}
