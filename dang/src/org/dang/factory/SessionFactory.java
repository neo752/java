package org.dang.factory;

import javax.servlet.http.HttpSession;

import org.dang.service.CartService;
import org.dang.service.cart.CartServiceImpl;
import org.dang.util.Constant;


public class SessionFactory {
	public static CartService getImplements(HttpSession session,String val){
		CartService obj=(CartService)session.getAttribute(val);
		if(obj==null){
			obj=new CartServiceImpl();
			session.setAttribute(Constant.SESSION_CART, obj);
		}
		return obj;
	}
}
