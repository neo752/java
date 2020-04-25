package org.dang.service.main;

import java.util.ArrayList;
import java.util.List;

import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Category;
import org.dang.service.MainService;

public class MainServiceImpl implements MainService {

	public List<Category> findLeftCategories() throws Exception {
		MainDao catDao = new MainDaoImpl();
		List<Category> all = catDao.findAllCategory();
		List<Category> cats = findByParentId(1, all);
		for (Category cat : cats) {
			List<Category> subCats = findByParentId(cat.getId(), all);
			cat.setSubCats(subCats);
		}
		return cats;
	}
    
	private List<Category> findByParentId(int pid, List<Category> all) {
		List<Category> subCats = new ArrayList<Category>();
		for (Category cat : all) {
			if (cat.getParent_id() == pid) {
				subCats.add(cat);
			}
		}
		return subCats;
	}

	public int[] getPages(int pagecount, int page, int pagesize)
			throws Exception {
		int[] pages = null;
		if (pagecount <= 1) {
			pages = new int[] { 1 };
			return pages;
		} else if (page <= 5) {
			if (pagecount > 10) {
				pages = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, pagecount - 1,
						pagecount };
			} else {
				pages = new int[pagecount];
				for (int i = 0; i < pagecount; i++) {
					pages[i]=i+1;
				}
			}

			return pages;
		} else if (page > 5 && page < pagecount - 8) {
			pages = new int[] { page - 4, page - 3, page - 2, page - 1, page,
					page + 1, page + 2, page + 3, pagecount - 1, pagecount };
			return pages;
		}
		if(pagecount<10){
			pages = new int[pagecount];
			for (int i = 0; i < pagecount; i++) {
				pages[i]=i+1;
			}
		}else{
			pages = new int[] {pagecount - 9,pagecount - 8,pagecount - 7,pagecount - 6,
					pagecount - 5,pagecount - 4,pagecount - 3,pagecount - 2, pagecount - 1, pagecount };
		}
		
		
		
		return pages;
	}
}
