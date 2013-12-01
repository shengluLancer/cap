package com.sears.SYWL.p2p.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_STORE")
public class Store {

	@Id
	@GeneratedValue
	@Column(name="STORE_ID")
	private int storeId;
	@Column(name="STORE_NAME")
	private String storeName;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
