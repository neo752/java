package org.dang.dao;

import java.util.List;

import org.dang.entity.Book;
import org.dang.entity.Category;
import org.dang.entity.Product;


public interface MainDao {
		public List<Category> findAllCategory() throws Exception;
		public List<Product> findAllNewProduct(int size) throws Exception;
		public List<Book> findAllRecommendBook() throws Exception;
		public List<Category> findByparentId(int id) throws Exception;
		public List<Book> findBooksByCatId(int id,int page,int pagesize,String where) throws Exception;
		public List<Product> findAllTopProduct(int size) throws Exception;
		public int findRowsNum(int cid,int pagesize) throws Exception ;
		public List<Book> findBooksByProductName(String searchval,int page,int pagesize) throws Exception;
		public int findSearchRows(String searchval,int page,int pagesize) throws Exception;
		public List<Product> findAllHotNewTopProduct(int size,long begin,long end) throws Exception ;
		public Book findBookById(int id) throws Exception;
}
