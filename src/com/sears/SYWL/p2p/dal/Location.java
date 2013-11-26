package com.sears.SYWL.p2p.dal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCATION")
public class Location {
	@Id
	@GeneratedValue
	@Column(name="LOCATION_ID")
	private int locationId;	
	@Column(name="ADDRESS")
	private String address;
	@Column(name="LATITUDE")
	private double latitude;
	@Column(name="LONGITUDE")
	private double longitude;
	@Column(name="TIMESTAMP")
	private long timestamp;
	
	
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


}
