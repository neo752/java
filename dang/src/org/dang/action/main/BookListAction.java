package org.dang.action.main;

import java.util.List;

import org.dang.action.BaseAction;
import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Book;
import org.dang.entity.Category;
import org.dang.service.MainService;
import org.dang.service.main.MainServiceImpl;


public class BookListAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private int pid;
	private int cid;
	private List<Category> cats;
	private int totalNum=0;
	private List<Book> books;
	private int page,pagesize,totolPages;
	private int[] pages;
	private int where;
	

	public String execute() {
		MainDao mDao = new MainDaoImpl();
		MainService ms=new MainServiceImpl();
		try {
			cats=mDao.findByparentId(pid);
			for (Category cat : cats) {
				totalNum+=cat.getPnum();
			}
			totolPages = mDao.findRowsNum(cid,pagesize);
			//验证当前点击页数正则
			String pagess=String.valueOf(page);
			page=pagess==null?1:page;
			page=pagess==""?1:page;
			int count=totolPages;
			page=page<1?1:page;
			page=page>count?count:page;
			String whereString="";
			switch (where) {
			case 1:
				whereString="order by dp.add_time";
				break;
			case 2:
				whereString="order by dp.add_time desc";
				break;
			case 3:
				whereString="order by dp.dang_price";
				break;
			case 4:
				whereString="order by dp.dang_price desc";
				break;

			default:whereString="";
				break;
			}
			int id=cid;
			if(cid<9){
				id=pid;
			}
			books = mDao.findBooksByCatId(id,page,pagesize,whereString);
			pages = ms.getPages(totolPages,page,pagesize);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}

	public int getWhere() {
		return where;
	}

	public void setWhere(int where) {
		this.where = where;
	}

}
