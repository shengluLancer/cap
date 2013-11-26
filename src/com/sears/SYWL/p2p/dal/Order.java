package com.sears.SYWL.p2p.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORDER")
public class Order {

	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private int orderId;
	@Column(name="ORDER_NAME")
	private String orderName;
	@Column(name="COUNT")
	private int count;
	@Column(name="PRETAX_PRICE")
	private double preTaxPrice;
	@Column(name="TAX")
	private double tax;
	@Column(name="TOTAL_PRICE")
	private double totalPrice;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public double getPreTaxPrice() {
		return preTaxPrice;
	}
	public void setPreTaxPrice(double preTaxPrice) {
		this.preTaxPrice = preTaxPrice;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
