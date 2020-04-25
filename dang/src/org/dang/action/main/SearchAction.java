package org.dang.action.main;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.dang.action.BaseAction;
import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Book;
import org.dang.service.MainService;
import org.dang.service.main.MainServiceImpl;


public class SearchAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private int totalNum=0;
	private List<Book> books;
	private int page,pagesize,totolPages;
	private int[] pages;
	private String searchval;

	public String execute() {
		MainDao mDao = new MainDaoImpl();
		MainService ms=new MainServiceImpl();
		try {
			searchval=searchval==null?"":URLDecoder.decode(searchval,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			totolPages = mDao.findSearchRows(searchval,page,pagesize);
			//验证当前点击页数正则
			String pagess=String.valueOf(page);
			page=pagess==null?1:page;
			page=pagess==""?1:page;
			int count=totolPages;
			page=page<1?1:page;
			page=page>count?count:page;
			books = mDao.findBooksByProductName(searchval,page,pagesize);
			pages = ms.getPages(totolPages,page,pagesize);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getSearchval() {
		return searchval;
	}

	public void setSearchval(String searchval) {
		this.searchval = searchval;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	public int getTotolPages() {
		return totolPages;
	}

	public void setTotolPages(int totolPages) {
		this.totolPages = totolPages;
	}

	public int[] getPages() {
		return pages;
	}

	public void setPages(int[] pages) {
		this.pages = pages;
	}


	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
