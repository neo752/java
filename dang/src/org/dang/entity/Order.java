package org.dang.entity;

import java.sql.Date;

public class Order {
	private int id ,user_id ,status ;
	private Date order_time;
	private double total_price;
	private String order_desc,receive_name,full_address,postal_code,mobile,phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		this.user_id = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date orderTime) {
		this.order_time = orderTime;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double totalPrice) {
		this.total_price = totalPrice;
	}
	public String getOrder_desc() {
		return order_desc;
	}
	public void setOrder_desc(String orderDesc) {
		this.order_desc = orderDesc;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receiveName) {
		this.receive_name = receiveName;
	}
	public String getFull_address() {
		return full_address;
	}
	public void setFull_address(String fullAddress) {
		this.full_address = fullAddress;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postalCode) {
		this.postal_code = postalCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
