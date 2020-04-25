package org.dang.dao;

import java.util.List;

import org.dang.entity.*;

public interface AdminDao {
	public int FindAll(String tablename,int pagesize) throws Exception;
	public List<User> UserFindAll(int page,int pagesize) throws Exception;
	public List<Product> ProductFindAll(int page,int pagesize) throws Exception;
	public List<Category> CategoryFindAll(int page,int pagesize) throws Exception;
	public List<CategoryProduct> CategoryproductFindAll(int page,int pagesize) throws Exception;
	public List<Item> ItemFindAll(int page,int pagesize) throws Exception;
	public List<Order> OrderFindAll(int page,int pagesize) throws Exception;
	public List<ReceiveAddress> ReceiveaddressFindAll(int page,int pagesize) throws Exception;
	public List<UpFile> UpfileFindAll(int page,int pagesize) throws Exception;
	public List<Book> BookFindAll(int page,int pagesize) throws Exception;
	public void modifyByUser(User u,int oldid) throws Exception;
	public void modifyByProduct(Product b,int oldid) throws Exception;
	public void modifyByCategory(Category b,int oldid) throws Exception;
	public void modifyByCategoryproduct(CategoryProduct b,int oldid) throws Exception;
	public void modifyByItem(Item b,int oldid) throws Exception;
	public void modifyByOrder(Order b,int oldid) throws Exception;
	public void modifyByReceiveaddress(ReceiveAddress b,int oldid) throws Exception;
	public void modifyByBook(Book b,int oldid) throws Exception;
	public void modifyByUpfile(UpFile b,int oldid) throws Exception;
	public void delUserById(int id)throws Exception;
	public void delProductById(int id) throws Exception;
	public void delCategoryById(int id) throws Exception;
	public void delCategoryproductById(int id) throws Exception;
	public void delItemById(int id) throws Exception;
	public void delOrderById(int id) throws Exception;
	public void delReceiveaddressById(int id) throws Exception;
	public void delBookById(int id) throws Exception;
	public void delUpfileById(int id) throws Exception;
	public void addUser(User u) throws Exception;
	public void addProduct(Product b) throws Exception;
	public void addCategoryproduct(CategoryProduct b) throws Exception;
	public void addCategory(Category b) throws Exception;
	public void addItem(Item b) throws Exception;
	public void addOrder(Order b) throws Exception;
	public void addReceiveaddress(ReceiveAddress b) throws Exception;
	public void addBook(Book b) throws Exception;
	public void addUpfile(UpFile b) throws Exception;
}
