package org.dang.service;

import java.util.List;

import org.dang.entity.Cart;

public interface CartService {
	public List<Cart> findAll() throws Exception;
	public boolean addCartById(int id) throws Exception;
	public void delCartById(int id) throws Exception;
	public void modifyCartQty(int id,int qtytype) throws Exception;
	public void undelCartById(int id) throws Exception;
	public double getTotalPrice() throws Exception;
	public double getTakePrice() throws Exception;
	public void removeCartById(int id) throws Exception;
	public void removeAllCart()throws Exception;
	public void removeUpCart()throws Exception;
	public void removeDownCart()throws Exception;
	public int getCartSize()throws Exception;
}
