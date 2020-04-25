package org.dang.action.main;

import java.util.List;

import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Product;

public class NewHotAction {
	private List<Product> plist;
	
	
	public String execute(){
		MainDao mDao=new MainDaoImpl();
		int size=8;
		try {
			plist=mDao.findAllTopProduct(size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public List<Product> getPlist() {
		return plist;
	}

	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	
	
	
}
