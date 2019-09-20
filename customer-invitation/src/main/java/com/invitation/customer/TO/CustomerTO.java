package com.invitation.customer.TO;

import java.io.Serializable;

public class CustomerTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userId;
	private String name;
	private double latitude;
	private double longitude;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
