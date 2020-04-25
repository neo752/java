package org.dang.entity;

public class Item {
	private int id,order_id,product_id,product_num;
	private String product_name ;
	private double dang_price,amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int orderId) {
		order_id = orderId;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int productId) {
		product_id = productId;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int productNum) {
		product_num = productNum;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String productName) {
		product_name = productName;
	}
	public double getDang_price() {
		return dang_price;
	}
	public void setDang_price(double dangPrice) {
		dang_price = dangPrice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
