package org.dang.service;

import java.util.List;

import org.dang.entity.Category;

public interface MainService {
	public List<Category> findLeftCategories() throws Exception;
	public int[] getPages(int totolPages, int page, int pagesize)	throws Exception;
}
