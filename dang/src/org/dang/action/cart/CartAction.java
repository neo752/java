package org.dang.action.cart;

import java.util.List;

import org.dang.action.BaseAction;
import org.dang.entity.Cart;
import org.dang.factory.SessionFactory;
import org.dang.service.CartService;
import org.dang.service.cart.CartServiceImpl;
import org.dang.util.Constant;

public class CartAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private List<Cart> carts;
	private int id;
	private int qtytype;
	private boolean buy;
	private double totalprice,takeprice;
	private int cartsize;
	
	public String findall(){
		CartService cs=(CartServiceImpl)
			SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			carts=cs.findAll();
			gettotalAndtakeprice();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String gettotalAndtakeprice(){
		CartService cs=(CartServiceImpl)
			SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			buy=true;
			totalprice=cs.getTotalPrice();
			takeprice=cs.getTakePrice();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
		
	public String add(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			buy=cs.addCartById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String del(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.delCartById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String modify(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.modifyCartQty(id, qtytype);
			gettotalAndtakeprice();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String undel(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.undelCartById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String remove(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.removeCartById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String clearall(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.removeAllCart();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String clearup(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.removeUpCart();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String cleardown(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cs.removeDownCart();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public String cartnum(){
		CartService cs=(CartServiceImpl)
		SessionFactory.getImplements(session, Constant.SESSION_CART);
		try {
			cartsize=cs.getCartSize();
			carts=cs.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtytype() {
		return qtytype;
	}
	public void setQtytype(int qtytype) {
		this.qtytype = qtytype;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public double getTakeprice() {
		return takeprice;
	}
	public void setTakeprice(double takeprice) {
		this.takeprice = takeprice;
	}
	public int getCartsize() {
		return cartsize;
	}
	public void setCartsize(int cartsize) {
		this.cartsize = cartsize;
	}
	
	
}
