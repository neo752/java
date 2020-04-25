package org.dang.action.order;

import java.sql.Date;
import java.util.List;

import org.dang.action.BaseAction;
import org.dang.dao.OrderDao;
import org.dang.dao.order.OrderDaoImpl;
import org.dang.entity.Cart;
import org.dang.entity.Item;
import org.dang.entity.Order;
import org.dang.entity.ReceiveAddress;
import org.dang.entity.User;
import org.dang.factory.SessionFactory;
import org.dang.service.CartService;
import org.dang.service.cart.CartServiceImpl;
import org.dang.util.Constant;

public class OrderAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Order order;
	private ReceiveAddress radd;
	private Item item;
	private List<Order> orderList;
	private List<Item> itemList;
	private List<ReceiveAddress> relist;
	private int addresswrite;
	private int totalprice;
	private double ordertotalprice;
	
	public String findalladdress(){
		OrderDao odao=new OrderDaoImpl();
		int id=((User) session.getAttribute(Constant.SESSION_USER)).getId();
		try {
			relist=	odao.findAllAddressByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String orderfindall(){
		OrderDao odao=new OrderDaoImpl();
		int id=((User) session.getAttribute(Constant.SESSION_USER)).getId();
		try {
			orderList=	odao.findAllOrderByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String order_ok(){
		OrderDao odao=new OrderDaoImpl();
		int id=((User) session.getAttribute(Constant.SESSION_USER)).getId();
		CartService cs=(CartServiceImpl)
			SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			//向地址表写入数据
			if(addresswrite==1){
				radd.setUser_id(id);
				odao.AddAddress(radd);
			}
			//向订单表写入数据
			order=new Order();
			order.setFull_address(radd.getFull_address());
			order.setMobile(radd.getMobile());
			order.setOrder_desc("这是一个订单");
			order.setOrder_time(new Date(System.currentTimeMillis()));
			order.setPhone(radd.getPhone());
			order.setPostal_code(radd.getPostal_code());
			order.setReceive_name(radd.getReceive_name());
			order.setStatus(Constant.ORDER);
			order.setTotal_price(cs.getTotalPrice());
			order.setUser_id(id);
			int num=odao.AddOrder(order);
			//向已购表写入数据
			List<Cart> carts=cs.findAll();
			if(carts.size()>0){
				for(int i=0;i<carts.size();i++){
					Cart cart=carts.get(i);
					if(cart.getBuy()){
						item=new Item();
						item.setDang_price(cart.getProduct().getDang_price());
						item.setProduct_id(cart.getProduct().getId());
						item.setProduct_name(cart.getProduct().getProductname());
						item.setProduct_num(cart.getQty());
						item.setAmount(cart.getProduct().getDang_price()*cart.getQty());
						item.setOrder_id(num);
						odao.AddItem(item);
					}
				}
			}
			ordertotalprice=cs.getTotalPrice();
			totalprice=num;
			//删除session
			session.removeAttribute(Constant.SESSION_CART);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String item_info(){
		OrderDao odao=new OrderDaoImpl();
		try {
			itemList=odao.findAllItemByOrderId(order.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String deladdress(){
		OrderDao odao=new OrderDaoImpl();
		try {
			odao.delAddressById(radd.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<ReceiveAddress> getRelist() {
		return relist;
	}

	public void setRelist(List<ReceiveAddress> relist) {
		this.relist = relist;
	}

	public int getAddresswrite() {
		return addresswrite;
	}

	public void setAddresswrite(int addresswrite) {
		this.addresswrite = addresswrite;
	}
	public ReceiveAddress getRadd() {
		return radd;
	}
	public void setRadd(ReceiveAddress radd) {
		this.radd = radd;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public double getOrdertotalprice() {
		return ordertotalprice;
	}
	public void setOrdertotalprice(double ordertotalprice) {
		this.ordertotalprice = ordertotalprice;
	}
	
	
	
}
