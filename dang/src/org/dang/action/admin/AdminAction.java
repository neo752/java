package org.dang.action.admin;

import java.util.List;

import org.dang.dao.AdminDao;
import org.dang.dao.admin.AdminDaoimpl;
import org.dang.entity.*;

public class AdminAction {
	private boolean ok;
	private int oldid;
	private List<Product> plist;
	private List<User> ulist;
	private List<Book> blist;
	private List<Category> clist;
	private List<CategoryProduct> cplist;
	private List<Item> ilist;
	private List<Order> olist;
	private List<ReceiveAddress> rlist;
	private List<UpFile> uplist;
	private User user;
	private Book book;
	private Category category;
	private Item item;
	private Order order;
	private Product product;
	private ReceiveAddress receiveaddress;
	private CategoryProduct categoryproduct;
	private UpFile upfile;
	private String tabletype;
	private int page;
	private int pagesize;
	private int totalpage;
	private int totalrows;
	
	private int getOKpage(int p,AdminDao aDao) throws Exception{
		if(tabletype==null||tabletype.equals("user")){
			totalrows=aDao.FindAll("user",pagesize);
		}else if(tabletype.equals("book")){
			totalrows=aDao.FindAll("book",pagesize);
		}else if(tabletype.equals("category")){
			totalrows=aDao.FindAll("category",pagesize);
		}else if(tabletype.equals("item")){
			totalrows=aDao.FindAll("item",pagesize);
		}else if(tabletype.equals("order")){
			totalrows=aDao.FindAll("order",pagesize);
		}else if(tabletype.equals("product")){
			totalrows=aDao.FindAll("product",pagesize);
		}else if(tabletype.equals("receiveaddress")){
			totalrows=aDao.FindAll("receive_address",pagesize);
		}else if(tabletype.equals("upfile")){
			totalrows=aDao.FindAll("upfile",pagesize);
		}else if(tabletype.equals("categoryproduct")){
			totalrows=aDao.FindAll("category_product",pagesize);
		}
		totalpage=(totalrows/pagesize)<1?1:totalpage;
		if (totalrows % pagesize == 0) {
			totalpage= totalrows / pagesize;
		} else {
			totalpage= totalrows / pagesize + 1;
		}
		p=p>totalpage?totalpage:p;
		p=p<1?1:p;
		return p;
	}
	//用户查询
	public String user(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			ulist=aDao.UserFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//书查询
	public String book(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			blist=aDao.BookFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//类别查询
	public String category(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			clist=aDao.CategoryFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//已购查询
	public String item(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			ilist=aDao.ItemFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//订单查询
	public String order(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			olist=aDao.OrderFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//商品查询
	public String product(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			plist=aDao.ProductFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//地址查询
	public String receiveaddress(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			rlist=aDao.ReceiveaddressFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//类别商品关联查询
	public String categoryproduct(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			cplist=aDao.CategoryproductFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	//文件查询
	public String upfile(){
		AdminDao aDao=new AdminDaoimpl();
		try {
			page=getOKpage(page,aDao);
			uplist=aDao.UpfileFindAll(page,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	//所有表的修改
	public String adminModify(){
		AdminDao aDao=new AdminDaoimpl();
		
		try {
			if(tabletype.equals("user")){
				aDao.modifyByUser(user,oldid);
			}else if(tabletype.equals("book")){
				aDao.modifyByBook(book,oldid);
			}else if(tabletype.equals("category")){
				aDao.modifyByCategory(category,oldid);
			}else if(tabletype.equals("item")){
				aDao.modifyByItem(item,oldid);
			}else if(tabletype.equals("order")){
				aDao.modifyByOrder(order,oldid);
			}else if(tabletype.equals("product")){
				aDao.modifyByProduct(product,oldid);
			}else if(tabletype.equals("receiveaddress")){
				aDao.modifyByReceiveaddress(receiveaddress,oldid);
			}else if(tabletype.equals("upfile")){
				aDao.modifyByUpfile(upfile,oldid);
			}else if(tabletype.equals("categoryproduct")){
				aDao.modifyByCategoryproduct(categoryproduct, oldid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		ok=true;
		return "success";
	}
	//所有表的删除
		public String adminDel(){
			AdminDao aDao=new AdminDaoimpl();
			try {
				if(tabletype.equals("user")){
					aDao.delUserById(user.getId());
				}else if(tabletype.equals("book")){
					aDao.delBookById(book.getId());
				}else if(tabletype.equals("category")){
					aDao.delCategoryById(category.getId());
				}else if(tabletype.equals("item")){
					aDao.delItemById(item.getId());
				}else if(tabletype.equals("order")){
					aDao.delOrderById(order.getId());
				}else if(tabletype.equals("product")){
					aDao.delProductById(product.getId());
				}else if(tabletype.equals("receiveaddress")){
					aDao.delReceiveaddressById(receiveaddress.getId());
				}else if(tabletype.equals("upfile")){
					aDao.delUpfileById(upfile.getId());
				}else if(tabletype.equals("categoryproduct")){
					aDao.delCategoryproductById(categoryproduct.getId());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			ok=true;
			return "success";
		}
	//所有表的添加
		public String adminAdd(){
			AdminDao aDao=new AdminDaoimpl();
			try {
				if(tabletype.equals("user")){
					aDao.addUser(user);
				}else if(tabletype.equals("book")){
					aDao.addBook(book);
				}else if(tabletype.equals("category")){
					aDao.addCategory(category);
				}else if(tabletype.equals("item")){
					aDao.addItem(item);
				}else if(tabletype.equals("order")){
					if(order==null){
						return "success";
					}
					aDao.addOrder(order);
				}else if(tabletype.equals("product")){
					aDao.addProduct(product);
				}else if(tabletype.equals("receiveaddress")){
					aDao.addReceiveaddress(receiveaddress);
				}else if(tabletype.equals("upfile")){
					aDao.addUpfile(upfile);
				}else if(tabletype.equals("categoryproduct")){
					aDao.addCategoryproduct(categoryproduct);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			ok=true;
			return "success";
		}
	public List<Product> getPlist() {
		return plist;
	}

	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}

	public List<User> getUlist() {
		return ulist;
	}

	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}

	public boolean isOk() {
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
	public String getTabletype() {
		return tabletype;
	}
	public void setTabletype(String tabletype) {
		this.tabletype = tabletype;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ReceiveAddress getReceiveaddress() {
		return receiveaddress;
	}

	public void setReceiveaddress(ReceiveAddress receiveaddress) {
		this.receiveaddress = receiveaddress;
	}

	public UpFile getUpfile() {
		return upfile;
	}

	public void setUpfile(UpFile upfile) {
		this.upfile = upfile;
	}
	public List<Book> getBlist() {
		return blist;
	}
	public void setBlist(List<Book> blist) {
		this.blist = blist;
	}
	public List<Category> getClist() {
		return clist;
	}
	public void setClist(List<Category> clist) {
		this.clist = clist;
	}
	public List<Item> getIlist() {
		return ilist;
	}
	public void setIlist(List<Item> ilist) {
		this.ilist = ilist;
	}
	public List<Order> getOlist() {
		return olist;
	}
	public void setOlist(List<Order> olist) {
		this.olist = olist;
	}
	public List<ReceiveAddress> getRlist() {
		return rlist;
	}
	public void setRlist(List<ReceiveAddress> rlist) {
		this.rlist = rlist;
	}
	public List<UpFile> getUplist() {
		return uplist;
	}
	public void setUplist(List<UpFile> uplist) {
		this.uplist = uplist;
	}
	public CategoryProduct getCategoryproduct() {
		return categoryproduct;
	}
	public void setCategoryproduct(CategoryProduct categoryproduct) {
		this.categoryproduct = categoryproduct;
	}
	public int getOldid() {
		return oldid;
	}
	public void setOldid(int oldid) {
		this.oldid = oldid;
	}
	public List<CategoryProduct> getCplist() {
		return cplist;
	}
	public void setCplist(List<CategoryProduct> cplist) {
		this.cplist = cplist;
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
	
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	
	
}
