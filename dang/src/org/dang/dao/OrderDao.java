package org.dang.dao;

import java.util.List;

import org.dang.entity.*;

public interface OrderDao {
	public List<ReceiveAddress> findAllAddressByUserId(int id)throws Exception;
	public void AddAddress(ReceiveAddress ra)throws Exception;
	public int AddOrder(Order order)throws Exception;
	public void AddItem(Item item)throws Exception;
	public List<Order> findAllOrderByUserId(int id) throws Exception;
	public List<Item> findAllItemByOrderId(int id)throws Exception;
	public void delAddressById(int id)throws Exception;
	
}
