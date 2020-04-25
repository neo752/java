package org.dang.service.cart;

import java.util.ArrayList;
import java.util.List;

import org.dang.dao.CartDao;
import org.dang.dao.cart.CartDaoImpl;
import org.dang.entity.Cart;
import org.dang.service.CartService;

public class CartServiceImpl implements CartService{
	List<Cart> Carts=new ArrayList<Cart>();
	public boolean addCartById(int id) throws Exception {
		for(int i=0;i<Carts.size();i++){
			Cart cart=Carts.get(i);
			if(cart.getProduct().getId()==id){
				if(!cart.getBuy()){
					cart.setBuy(true);
				}
				return false;
			}
		}
		Cart c=new Cart();
		CartDao cdao=new CartDaoImpl();
		c.setProduct(cdao.findAllProductById(id));
		Carts.add(c);
		return true;
	}

	public void delCartById(int id) throws Exception {
		for (int i = 0; i < Carts.size(); i++) {
			Cart cart=Carts.get(i);
			if(cart.getProduct().getId()==id){
				cart.setBuy(false);
			}
		}
		
	}
	public void undelCartById(int id) throws Exception {
		for (int i = 0; i < Carts.size(); i++) {
			Cart cart=Carts.get(i);
			if(cart.getProduct().getId()==id){
				cart.setBuy(true);
			}
		}
		
	}
	public void removeCartById(int id) throws Exception {
		for (int i = 0; i < Carts.size(); i++) {
			Cart cart=Carts.get(i);
			if(cart.getProduct().getId()==id){
				Carts.remove(i);
				return;
			}
		}
		
	}
	public List<Cart> findAll() throws Exception {
		return Carts;
	}
	public double getTotalPrice() throws Exception {
		double total=0;
		for (int i = 0; i < Carts.size(); i++) {
				Cart cart=Carts.get(i);
				if(cart.getBuy()){
				total+=cart.getQty()*cart.getProduct().getDang_price();
				}
		}
			return total;
	}
	public double getTakePrice() throws Exception {
		double take=0;
		for (int i = 0; i < Carts.size(); i++) {
				Cart cart=Carts.get(i);
				if(cart.getBuy()){
				take+=cart.getQty()
					*(cart.getProduct().getFixed_price()-cart.getProduct().getDang_price());
			}
		}
			return take;
		
	}
	public void modifyCartQty(int id, int qtytype) throws Exception {
		System.out.println(id+"||"+qtytype);
			for (int i = 0; i < Carts.size(); i++) {
				Cart cart=Carts.get(i);
				if(cart.getProduct().getId()==id){
					if(qtytype==1){
						cart.setQty(cart.getQty()+1);
					}else{
						if(cart.getQty()<=1){
							cart.setQty(1);
						}else{
							cart.setQty(cart.getQty()-1);
						}
					}
				}
				
			}
		
		
	}

	public void removeAllCart() throws Exception {
		Carts.clear();
	}

	public void removeDownCart() throws Exception {
		for (int i = 0; i < Carts.size(); i++) {
			Cart cart=Carts.get(i);
			if(!cart.getBuy()){
				Carts.remove(i);
				i--;
			}
		}
	}

	public void removeUpCart() throws Exception {
		for (int i = 0; i < Carts.size(); i++) {
			Cart cart=Carts.get(i);
			if(cart.getBuy()){
				Carts.remove(i);
				i--;
			}
		}
	}

	public int getCartSize() throws Exception {
		int a=0;
		for (int i = 0; i < Carts.size(); i++) {
			Cart cart=Carts.get(i);
			if(cart.getBuy()){
				a++;
			}
		}
		return a;
	}

}
