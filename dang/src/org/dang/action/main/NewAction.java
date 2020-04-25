package org.dang.action.main;

import java.util.List;

import org.dang.action.BaseAction;
import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Product;

public class NewAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private int size;
	private List<Product> pros;
	
	public String execute(){
		MainDao pdao=new MainDaoImpl();
		try {
			size=8;
			pros=pdao.findAllNewProduct(size);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Product> getPros() {
		return pros;
	}
	public void setPros(List<Product> pros) {
		this.pros = pros;
	}
	
	
	
	
}
