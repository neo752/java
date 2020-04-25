package org.dang.action.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.dang.action.BaseAction;
import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Book;


public class RecommendAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	List<Book> blist;
	public String execute(){
		Random r = new Random();
		MainDao mdao=new MainDaoImpl();
		try {

		 blist=mdao.findAllRecommendBook();
			int r1=r.nextInt(blist.size());
			int r2=r.nextInt(blist.size());
			List<Book> sublist=new ArrayList<Book>();
			sublist.add(blist.get(r1));
			sublist.add(blist.get(r2));
			blist=sublist;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public List<Book> getBlist() {
		return blist;
	}
	public void setBlist(List<Book> blist) {
		this.blist = blist;
	}
	
}
