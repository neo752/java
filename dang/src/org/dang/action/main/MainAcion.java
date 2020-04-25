package org.dang.action.main;

import org.dang.action.BaseAction;
import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Book;
import org.dang.entity.User;
import org.dang.util.Constant;

public class MainAcion extends BaseAction{
	private static final long serialVersionUID = 1L;
		private boolean ok;
		private User user;
		private Book book;
		private int bookid;
	// 退出登陆
	public String removeUser1() {
		//删除所有session
		session.removeAttribute(Constant.SESSION_USER);
		session.removeAttribute(Constant.SESSION_UPFILE);
		session.removeAttribute(Constant.SESSION_CART);
		//获得先前页面ip
		String ippath=(String)session.getAttribute(Constant.SESSION_IPPATH);
		//所有需跳转页面
		if(ippath.equals("user_main")){
			ok=false;
			return "success";
		}
		ok=true;
		return "success";

	}
	public String findbookbyid(){
		System.out.println(bookid);
		MainDao mDao=new MainDaoImpl();
		try {
			book=mDao.findBookById(bookid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public boolean getOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	
	
	
	
	
	
}
