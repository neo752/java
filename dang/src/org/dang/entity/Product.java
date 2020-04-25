package org.dang.entity;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id,has_deleted;
	private String productname,description,keywords,productpic;
	private Date addtime;
	private double dang_price,fixed_price;
	private int countnum;
	


	public int getCountnum() {
		return countnum;
	}
	public void setCountnum(int countnum) {
		this.countnum = countnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHas_deleted() {
		return has_deleted;
	}
	public void setHas_deleted(int hasDeleted) {
		has_deleted = hasDeleted;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getProductpic() {
		return productpic;
	}
	public void setProductpic(String productpic) {
		this.productpic = productpic;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public double getDang_price() {
		return dang_price;
	}
	public void setDang_price(double dangPrice) {
		dang_price = dangPrice;
	}
	public double getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(double fixedPrice) {
		fixed_price = fixedPrice;
	}
	
}
