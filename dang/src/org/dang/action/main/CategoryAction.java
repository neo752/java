package org.dang.action.main;

import java.util.List;

import org.dang.action.BaseAction;
import org.dang.entity.Category;
import org.dang.service.MainService;
import org.dang.service.main.MainServiceImpl;

public class CategoryAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private List<Category> cats;
	
	public String findAllCategories() throws Exception{
		MainService service = new MainServiceImpl();
		cats = service.findLeftCategories();
		return "success";
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	
	
	
}
