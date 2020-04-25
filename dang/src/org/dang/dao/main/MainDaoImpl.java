package org.dang.dao.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dang.dao.MainDao;
import org.dang.entity.*;
import org.dang.util.DbUtil;

public class MainDaoImpl implements MainDao {

	public List<Category> findAllCategory() throws Exception {
		Connection conn = null;
		String sql = "select * from d_category order by parent_id";
		List<Category> clist = new ArrayList<Category>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setDescription(rs.getString("description"));
				c.setEn_name(rs.getString("en_name"));
				c.setName(rs.getString("name"));
				c.setParent_id(rs.getInt("parent_id"));
				c.setTurn(rs.getInt("turn"));

				clist.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return clist;
	}

	public List<Product> findAllNewProduct(int size) throws Exception {
		Connection conn = null;
		String sql = "select * from d_product where has_deleted=0 order by add_time desc limit 0,?";
		List<Product> plist = new ArrayList<Product>();
		try {

			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setAddtime(new Date(rs.getLong("add_time")));
				p.setDang_price(rs.getDouble("dang_price"));
				p.setDescription(rs.getString("description"));
				p.setFixed_price(rs.getDouble("fixed_price"));
				p.setHas_deleted(rs.getInt("has_deleted"));
				p.setId(rs.getInt("id"));
				p.setKeywords(rs.getString("keywords"));
				p.setProductname(rs.getString("product_name"));
				p.setProductpic(rs.getString("product_pic"));
				plist.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return plist;
	}

	public List<Book> findAllRecommendBook() throws Exception {
		Connection conn = null;
		String sql = "select * from  d_product dp join d_book db on(dp.id=db.id)";
		List<Book> blist = new ArrayList<Book>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setProductpic(rs.getString("product_pic"));
				b.setProductname(rs.getString("product_name"));
				b.setFixed_price(rs.getDouble("fixed_price"));
				b.setDang_price(rs.getDouble("dang_price"));
				b.setAuthor(rs.getString("author"));
				b.setPublishing(rs.getString("publishing"));
				b.setPublish_time(new Date(rs.getLong("publish_time")));
				b.setCatalogue(rs.getString("catalogue"));
				blist.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return blist;
	}

	public List<Book> findBooksByCatId(int id, int page, int pagesize,
			String where) throws Exception {
		Connection conn = null;
		String sql = "";
		if (id < 9) {
			sql = "select dp.*,db.* from d_category_product dcp join d_product dp on(dcp.product_id=dp.id) join d_book db on(dp.id=db.id) where dcp.cat_id in(select id from d_category where parent_id=?) "
					+ where + " limit ?,?";
		} else {
			sql = "select dp.*,db.* from d_category_product dcp join d_product dp on(dcp.product_id=dp.id) join d_book db on(dp.id=db.id) where dcp.cat_id=? "
					+ where + " limit ?,?";
		}
		List<Book> blist = new ArrayList<Book>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, (page - 1) * pagesize);
			ps.setInt(3, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setAddtime(new Date(rs.getLong("add_time")));
				b.setDang_price(rs.getDouble("dang_price"));
				b.setDescription(rs.getString("description"));
				b.setFixed_price(rs.getDouble("fixed_price"));
				b.setHas_deleted(rs.getInt("has_deleted"));
				b.setId(rs.getInt("id"));
				b.setKeywords(rs.getString("keywords"));
				b.setProductname(rs.getString("product_name"));
				b.setProductpic(rs.getString("product_pic"));

				b.setCatalogue(rs.getString("catalogue"));
				b.setAuthor(rs.getString("author"));
				b.setPublishing(rs.getString("publishing"));
				b.setPublish_time(new Date(rs.getLong("publish_time")));

				blist.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return blist;
	}

	public int findRowsNum(int id, int pagesize) throws Exception {
		int rownum = 0;
		Connection conn = null;
		String sql = "";
		if (id < 9) {
			sql = "select dp.*,db.* from d_category_product dcp join d_product dp on(dcp.product_id=dp.id) join d_book db on(dp.id=db.id) where dcp.cat_id in(select id from d_category where parent_id=?) ";
		} else {
			sql = "select dp.id,dp.product_pic from d_category_product dcp join d_product dp on(dcp.product_id=dp.id) join d_book db on(dp.id=db.id) where dcp.cat_id=?";
		}

		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rownum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		if (rownum == 0) {
			return 1;
		} else if (rownum % pagesize == 0) {

			return rownum / pagesize;
		} else {
			return rownum / pagesize + 1;
		}
	}

	public int findSearchRows(String searchval, int page, int pagesize)
			throws Exception {
		int rownum = 0;
		Connection conn = null;
		String sql = "";
		if (searchval == "") {
			sql = "select db.id from d_product dp join d_book db on(dp.id=db.id) ";
		} else {
			sql = "select db.id from d_product dp join d_book db on(dp.id=db.id) and dp.product_name like '%"
					+ searchval + "%'";
		}

		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rownum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		if (rownum == 0) {
			return 1;
		} else if (rownum % pagesize == 0) {

			return rownum / pagesize;
		} else {
			return rownum / pagesize + 1;
		}
	}

	public List<Book> findBooksByProductName(String searchval, int page,
			int pagesize) throws Exception {
		Connection conn = null;
		String sql = "";
		if (searchval == "") {
			sql = "select * from d_product dp join d_book db on(dp.id=db.id) limit ?,?";
		} else {
			sql = "select * from d_product dp join d_book db on(dp.id=db.id) and dp.product_name like '%"
					+ searchval + "%' limit ?,?";
		}
		List<Book> blist = new ArrayList<Book>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * pagesize);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setAddtime(new Date(rs.getLong("add_time")));
				b.setDang_price(rs.getDouble("dang_price"));
				b.setDescription(rs.getString("description"));
				b.setFixed_price(rs.getDouble("fixed_price"));
				b.setHas_deleted(rs.getInt("has_deleted"));
				b.setId(rs.getInt("id"));
				b.setKeywords(rs.getString("keywords"));
				b.setProductname(rs.getString("product_name"));
				b.setProductpic(rs.getString("product_pic"));
				b.setCatalogue(rs.getString("catalogue"));

				b.setAuthor(rs.getString("author"));
				b.setPublishing(rs.getString("publishing"));
				b.setPublish_time(new Date(rs.getLong("publish_time")));

				blist.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return blist;
	}

	public List<Category> findByparentId(int pid) throws Exception {
		Connection conn = null;
		String sql = "select dc.*,count(dcp.product_id)as pnum from d_category dc left outer join d_category_product dcp on(dc.id=dcp.cat_id) where dc.parent_id=? group by dc.id order by dc.turn";
		List<Category> clist = new ArrayList<Category>();
		try {

			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setDescription(rs.getString("description"));
				c.setEn_name(rs.getString("en_name"));
				c.setName(rs.getString("name"));
				c.setParent_id(rs.getInt("parent_id"));
				c.setTurn(rs.getInt("turn"));
				c.setPnum(rs.getInt("pnum"));
				clist.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return clist;
	}

	// ////////////////////////////////////////////////////////////////////////

	// ERROR 1235 (42000): This version of MySQL doesn't yet support 'LIMIT &
	// IN/ALL/AN
	// Y/SOME subquery'

	public List<Product> findAllTopProduct(int size) throws Exception {
		Connection conn = null;
		String sql = "select dp.*,di.count from d_product dp ,"
				+ "(select sum(product_num) count,product_id from d_item group by product_id "
				+ "order by count desc limit 0,?) di where has_deleted=0 "
				+ "and dp.id = di.product_id order by di.count desc;";
		List<Product> plist = new ArrayList<Product>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setAddtime(new Date(rs.getLong("add_time")));
				p.setDang_price(rs.getDouble("dang_price"));
				p.setDescription(rs.getString("description"));
				p.setFixed_price(rs.getDouble("fixed_price"));
				p.setHas_deleted(rs.getInt("has_deleted"));
				p.setId(rs.getInt("id"));
				p.setKeywords(rs.getString("keywords"));
				p.setProductname(rs.getString("product_name"));
				p.setProductpic(rs.getString("product_pic"));
				p.setCountnum(rs.getInt("count"));
				plist.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return plist;
	}

	// ////////////////////////////////////////////////////////////////////////
	public List<Product> findAllHotNewTopProduct(int size, long begin, long end)
			throws Exception {
		Connection conn = null;
		String sql = "select dp.*,di.count from d_product dp ,("
				+ "select sum(product_num) count,product_id from d_item group by product_id order by count desc"
				+ ") di where has_deleted=0 and dp.id = di.product_id and add_time between ? and ? order by di.count desc limit 0,?";
		List<Product> plist = new ArrayList<Product>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, begin);
			ps.setLong(2, end);
			ps.setInt(3, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setAddtime(new Date(rs.getLong("add_time")));
				p.setDang_price(rs.getDouble("dang_price"));
				p.setDescription(rs.getString("description"));
				p.setFixed_price(rs.getDouble("fixed_price"));
				p.setHas_deleted(rs.getInt("has_deleted"));
				p.setId(rs.getInt("id"));
				p.setKeywords(rs.getString("keywords"));
				p.setProductname(rs.getString("product_name"));
				p.setProductpic(rs.getString("product_pic"));
				p.setCountnum(rs.getInt("count"));
				plist.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return plist;
	}
	public Book findBookById(int id) throws Exception {
		Connection conn = null;
		Book b=null;
		String sql = "select * from d_product dp , d_book db where dp.id=db.id and dp.id=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = new Book();
				b.setId(id);
				b.setAddtime(new Date(rs.getLong("add_time")));
				b.setDang_price(rs.getDouble("dang_price"));
				b.setDescription(rs.getString("description"));
				b.setFixed_price(rs.getDouble("fixed_price"));
				b.setHas_deleted(rs.getInt("has_deleted"));
				b.setKeywords(rs.getString("keywords"));
				b.setProductname(rs.getString("product_name"));
				b.setProductpic(rs.getString("product_pic"));
				
				b.setAuthor(rs.getString("author"));
				b.setPublishing(rs.getString("publishing"));
				b.setPublish_time(new Date(rs.getLong("publish_time")));
				b.setAuthor_summary(rs.getString("author_summary"));
				b.setWord_number(rs.getString("word_number"));
				b.setWhich_edtion(rs.getString("which_edtion"));
				b.setTotal_page(rs.getString("total_page"));
				b.setPrint_time(new Date(rs.getLong("print_time")));
				b.setPrint_number(rs.getString("print_number"));
				b.setIsbn(rs.getString("isbn"));
				b.setCatalogue(rs.getString("catalogue"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return b;
	}

}
