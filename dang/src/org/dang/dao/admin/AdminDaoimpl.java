package org.dang.dao.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dang.dao.AdminDao;
import org.dang.entity.*;
import org.dang.util.DbUtil;

public class AdminDaoimpl implements AdminDao{
	public int FindAll(String tablename,int pagesize) throws Exception {
		Connection conn = null;
		String sql = "select * from d_"+tablename;
		int totalrows=0;
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				totalrows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		totalrows=totalrows<1?1:totalrows;
		return totalrows;

	}
//用户表
	public List<User> UserFindAll(int page,int pagesize) throws Exception {
			Connection conn = null;
			String sql = "select * from d_user order by id desc limit ?,?";
			List<User> user=new ArrayList<User>();
			try {
				conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, (page-1)*pagesize);
				ps.setInt(2, pagesize);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					User u=new User();
					u.setEmail(rs.getString("email"));
					u.setPassword(rs.getString("password"));
					u.setEmail_verify_code(rs.getString("email_verify_code"));
					u.setId(rs.getInt("id"));
					u.setIs_email_verify(rs.getString("is_email_verify"));
					u.setLast_login_ip(rs.getString("last_login_ip"));
					Date date=new Date(rs.getLong("last_login_time"));
					u.setLast_login_time(date);
					u.setNickname(rs.getString("nickname"));
					u.setUser_integral(rs.getInt("user_integral"));
					user.add(u);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtil.closeConnection();
			}
			return user;

		}
	
	public void modifyByUser(User u,int oldid) throws Exception {
		Connection conn = null;
		String sql = "update d_user set email=?,nickname=?,password=?,user_integral=?," +
				"is_email_verify=?,email_verify_code=?,last_login_time=?,last_login_ip=?,id=? where id=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getNickname());
			ps.setString(3,	u.getPassword());
			ps.setInt(4, u.getUser_integral());
			ps.setString(5, u.getIs_email_verify());
			ps.setString(6, u.getEmail_verify_code());
			ps.setLong(7, u.getLast_login_time().getTime());
			ps.setString(8, u.getLast_login_ip());
			ps.setInt(9, u.getId());
			ps.setInt(10, oldid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		
	}
	public void addUser(User u) throws Exception {
		Connection conn = null;
		String sql = "insert into d_user(email,nickname,password,user_integral," +
				"is_email_verify,email_verify_code,last_login_time,last_login_ip,id) value(?,?,?,?,?,?,?,?,?)";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getNickname());
			ps.setString(3,	u.getPassword());
			ps.setInt(4, u.getUser_integral());
			ps.setString(5, u.getIs_email_verify());
			ps.setString(6, u.getEmail_verify_code());
			ps.setLong(7, u.getLast_login_time().getTime());
			ps.setString(8, u.getLast_login_ip());
			ps.setInt(9, u.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		
	}
	public void delUserById(int id) throws Exception {
		Connection conn = null;
		String sql = "delete from d_user where id=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		
	}

//书表
		public List<Book> BookFindAll(int page,int pagesize) throws Exception {
				Connection conn = null;
				String sql = "select * from d_book order by id desc limit ?,?";
				List<Book> book=new ArrayList<Book>();
				try {
					conn = DbUtil.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, (page-1)*pagesize);
					ps.setInt(2, pagesize);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						Book b=new Book();
						b.setPublish_time(new Date(rs.getLong("publish_time")));
						b.setAuthor(rs.getString("author"));
						b.setId(rs.getInt("id"));
						b.setPublishing(rs.getString("publishing"));
						b.setWord_number(rs.getString("word_number"));
						b.setWhich_edtion(rs.getString("which_edtion"));
						b.setTotal_page(rs.getString("total_page"));
						b.setPrint_time(new Date(rs.getLong("print_time")));
						b.setPrint_number(rs.getString("print_number"));
						b.setIsbn(rs.getString("isbn"));
						b.setAuthor_summary(rs.getString("author_summary"));
						b.setCatalogue(rs.getString("catalogue"));
						book.add(b);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					DbUtil.closeConnection();
				}
				return book;

			}
		public void modifyByBook(Book b,int oldid) throws Exception {
			Connection conn = null;
			String sql = "update d_book set publish_time=?,author=?,publishing=?,word_number=?," +
					"which_edtion=?,total_page=?,print_time=?,print_number=?,isbn=?,author_summary=?," +
					"catalogue=?,id=? where id=?";
			try {
				conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setLong(1, b.getPublish_time().getTime());
				ps.setString(2, b.getAuthor());
				ps.setString(3, b.getPublishing());
				ps.setString(4, b.getWord_number());
				ps.setString(5, b.getWhich_edtion());
				ps.setString(6, b.getTotal_page());
				ps.setLong(7, b.getPrint_time().getTime());
				ps.setString(8, b.getPrint_number());
				ps.setString(9, b.getIsbn());
				ps.setString(10, b.getAuthor_summary());
				ps.setString(11, b.getCatalogue());
				ps.setInt(12, b.getId());
				ps.setInt(13, oldid);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtil.closeConnection();
			}
			
		}
		public void addBook(Book b) throws Exception {
			Connection conn = null;
			String sql = "insert into d_book(publish_time,author,publishing,word_number," +
					"which_edtion,total_page,print_time,print_number,isbn,author_summary," +
					"catalogue,id) value(?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setLong(1, b.getPublish_time().getTime());
				ps.setString(2, b.getAuthor());
				ps.setString(3, b.getPublishing());
				ps.setString(4, b.getWord_number());
				ps.setString(5, b.getWhich_edtion());
				ps.setString(6, b.getTotal_page());
				ps.setLong(7, b.getPrint_time().getTime());
				ps.setString(8, b.getPrint_number());
				ps.setString(9, b.getIsbn());
				ps.setString(10, b.getAuthor_summary());
				ps.setString(11, b.getCatalogue());
				ps.setInt(12, b.getId());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtil.closeConnection();
			}
			
		}
		public void delBookById(int id) throws Exception {
			Connection conn = null;
			String sql = "delete from d_book where id=?";
			try {
				conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtil.closeConnection();
			}
			
		}
//类别表
		public List<Category> CategoryFindAll(int page,int pagesize) throws Exception {
		Connection conn = null;
		String sql = "select * from d_category order by id desc limit ?,?";
		List<Category> category=new ArrayList<Category>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pagesize);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category c=new Category();
				c.setDescription(rs.getString("description"));
				c.setEn_name(rs.getString("en_name"));
				c.setName(rs.getString("name"));
				c.setParent_id(rs.getInt("parent_id"));
				c.setTurn(rs.getInt("turn"));
				c.setId(rs.getInt("id"));
				category.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return category;

	}
				public void modifyByCategory(Category c,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_category set description=?,en_name=?,name=?,parent_id=?," +
							"turn=?,id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, c.getDescription());
						ps.setString(2, c.getEn_name());
						ps.setString(3, c.getName());
						ps.setInt(4, c.getParent_id());
						ps.setInt(5, c.getTurn());
						ps.setInt(6, c.getId());
						ps.setInt(7, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addCategory(Category c) throws Exception {
					Connection conn = null;
					String sql = "insert into d_category(description,en_name,name,parent_id," +
							"turn,id) value(?,?,?,?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);

						ps.setString(1, c.getDescription());
						ps.setString(2, c.getEn_name());
						ps.setString(3, c.getName());
						ps.setInt(4, c.getParent_id());
						ps.setInt(5, c.getTurn());
						ps.setInt(6, c.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delCategoryById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_category where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
//商品表
				public List<Product> ProductFindAll(int page,int pagesize) throws Exception {
						Connection conn = null;
						String sql = "select * from d_product order by id desc limit ?,?";
						List<Product> product=new ArrayList<Product>();
						try {
							conn = DbUtil.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, (page-1)*pagesize);
							ps.setInt(2, pagesize);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								Product p=new Product();
								p.setAddtime(new Date(rs.getLong("add_time")));
								p.setDang_price(rs.getDouble("dang_price"));
								p.setDescription(rs.getString("description"));
								p.setFixed_price(rs.getDouble("fixed_price"));
								p.setHas_deleted(rs.getInt("has_deleted"));
								p.setId(rs.getInt("id"));
								p.setKeywords(rs.getString("keywords"));
								p.setProductname(rs.getString("product_name"));
								p.setProductpic(rs.getString("product_pic"));
								product.add(p);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							DbUtil.closeConnection();
						}
						return product;

					}
				public void modifyByProduct(Product p,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_product set add_time=?,dang_price=?,description=?,fixed_price=?," +
							"has_deleted=?,keywords=?,product_name=?,product_pic=?,id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setLong(1, p.getAddtime().getTime());
						ps.setDouble(2, p.getDang_price());
						ps.setString(3, p.getDescription());
						ps.setDouble(4, p.getFixed_price());
						ps.setInt(5, p.getHas_deleted());
						ps.setString(6, p.getKeywords());
						ps.setString(7, p.getProductname());
						ps.setString(8, p.getProductpic());
						ps.setInt(9, p.getId());
						ps.setInt(10, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addProduct(Product p) throws Exception {
					Connection conn = null;
					String sql = "insert into d_product(add_time,dang_price,description,fixed_price," +
							"has_deleted,keywords,product_name,product_pic,id) value(?,?,?,?,?,?,?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setLong(1, p.getAddtime().getTime());
						ps.setDouble(2, p.getDang_price());
						ps.setString(3, p.getDescription());
						ps.setDouble(4, p.getFixed_price());
						ps.setInt(5, p.getHas_deleted());
						ps.setString(6, p.getKeywords());
						ps.setString(7, p.getProductname());
						ps.setString(8, p.getProductpic());
						ps.setInt(9, p.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delProductById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_product where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
//商品类别关联表
				public List<CategoryProduct> CategoryproductFindAll(int page,int pagesize) throws Exception {
						Connection conn = null;
						String sql = "select * from d_category_product order by id desc limit ?,?";
						List<CategoryProduct> categoryproduct=new ArrayList<CategoryProduct>();
						try {
							conn = DbUtil.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, (page-1)*pagesize);
							ps.setInt(2, pagesize);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								CategoryProduct cp=new CategoryProduct();
								cp.setCat_id(rs.getInt("cat_id"));
								cp.setId(rs.getInt("id"));
								cp.setPrioduct_id(rs.getInt("product_id"));
								categoryproduct.add(cp);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							DbUtil.closeConnection();
						}
						return categoryproduct;

					}
				public void modifyByCategoryproduct(CategoryProduct cp,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_category_product set cat_id=?,product_id=?," +
							"id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, cp.getCat_id());
						ps.setInt(2, cp.getPrioduct_id());
						ps.setInt(3, cp.getId());
						ps.setInt(4, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addCategoryproduct(CategoryProduct cp) throws Exception {
					Connection conn = null;
					String sql = "insert into d_category_product(cat_id,product_id,id) value(?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, cp.getCat_id());
						ps.setInt(2, cp.getPrioduct_id());
						ps.setInt(3, cp.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delCategoryproductById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_category_product where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
//已购表
				public List<Item> ItemFindAll(int page,int pagesize) throws Exception {
						Connection conn = null;
						String sql = "select * from d_item order by id desc limit ?,?";
						List<Item> item=new ArrayList<Item>();
						try {
							conn = DbUtil.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, (page-1)*pagesize);
							ps.setInt(2, pagesize);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								Item i=new Item();
								i.setAmount(rs.getDouble("amount"));
								i.setDang_price(rs.getDouble("dang_price"));
								i.setId(rs.getInt("id"));
								i.setOrder_id(rs.getInt("order_id"));
								i.setProduct_id(rs.getInt("product_id"));
								i.setProduct_name(rs.getString("product_name"));
								i.setProduct_num(rs.getInt("product_num"));
								item.add(i);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							DbUtil.closeConnection();
						}
						return item;

					}
				public void modifyByItem(Item i,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_item set amount=?,dang_price=?,order_id=?,product_id=?," +
							"product_name=?,product_num=?,id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setDouble(1, i.getAmount());
						ps.setDouble(2, i.getDang_price());
						ps.setInt(3, i.getOrder_id());
						ps.setInt(4, i.getProduct_id());
						ps.setString(5, i.getProduct_name());
						ps.setInt(6, i.getProduct_num());
						ps.setInt(7, i.getId());
						ps.setInt(8, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addItem(Item i) throws Exception {
					Connection conn = null;
					String sql = "insert into d_item(amount,dang_price,order_id,product_id," +
							"product_name,product_num,id) value(?,?,?,?,?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setDouble(1, i.getAmount());
						ps.setDouble(2, i.getDang_price());
						ps.setInt(3, i.getOrder_id());
						ps.setInt(4, i.getProduct_id());
						ps.setString(5, i.getProduct_name());
						ps.setInt(6, i.getProduct_num());
						ps.setInt(7, i.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delItemById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_item where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
//订单表
				public List<Order> OrderFindAll(int page,int pagesize) throws Exception {
						Connection conn = null;
						String sql = "select * from d_order order by id desc limit ?,?";
						List<Order> order=new ArrayList<Order>();
						try {
							conn = DbUtil.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, (page-1)*pagesize);
							ps.setInt(2, pagesize);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								Order o=new Order();
								o.setFull_address(rs.getString("full_address"));
								o.setId(rs.getInt("id"));
								o.setMobile(rs.getString("mobile"));
								o.setOrder_desc(rs.getString("order_desc"));
								o.setOrder_time(new Date(rs.getLong("order_time")));
								o.setPhone(rs.getString("phone"));
								o.setPostal_code(rs.getString("postal_code"));
								o.setReceive_name(rs.getString("receive_name"));
								o.setStatus(rs.getInt("status"));
								o.setTotal_price(rs.getDouble("total_price"));
								o.setUser_id(rs.getInt("user_id"));
								order.add(o);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							DbUtil.closeConnection();
						}
						return order;

					}
				public void modifyByOrder(Order o,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_order set full_address=?,mobile=?,order_desc=?,order_time=?," +
							"phone=?,postal_code=?,receive_name=?,status=?,total_price=?,user_id=?,id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, o.getFull_address());
						ps.setString(2, o.getMobile());
						ps.setString(3, o.getOrder_desc());
						ps.setLong(4, o.getOrder_time().getTime());
						ps.setString(5, o.getPhone());
						ps.setString(6, o.getPostal_code());
						ps.setString(7, o.getReceive_name());
						ps.setInt(8, o.getStatus());
						ps.setDouble(9, o.getTotal_price());
						ps.setInt(10, o.getUser_id());
						ps.setInt(11, o.getId());
						ps.setInt(12, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addOrder(Order o) throws Exception {
					Connection conn = null;
					String sql = "insert into d_order(full_address,mobile,order_desc,order_time,phone,postal_code," +
							"receive_name,status,total_price,user_id,id) value(?,?,?,?,?,?,?,?,?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, o.getFull_address());
						ps.setString(2, o.getMobile());
						ps.setString(3, o.getOrder_desc());
						ps.setLong(4, o.getOrder_time().getTime());
						ps.setString(5, o.getPhone());
						ps.setString(6, o.getPostal_code());
						ps.setString(7, o.getReceive_name());
						ps.setInt(8, o.getStatus());
						ps.setDouble(9, o.getTotal_price());
						ps.setInt(10, o.getUser_id());
						ps.setInt(11, o.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delOrderById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_order where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
//地址表
				public List<ReceiveAddress> ReceiveaddressFindAll(int page,int pagesize) throws Exception {
						Connection conn = null;
						String sql = "select * from d_receive_address order by id desc limit ?,?";
						List<ReceiveAddress> receiveaddress=new ArrayList<ReceiveAddress>();
						try {
							conn = DbUtil.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, (page-1)*pagesize);
							ps.setInt(2, pagesize);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								ReceiveAddress r=new ReceiveAddress();
								r.setFull_address(rs.getString("full_address"));
								r.setId(rs.getInt("id"));
								r.setMobile(rs.getString("mobile"));
								r.setPhone(rs.getString("phone"));
								r.setPostal_code(rs.getString("postal_code"));
								r.setReceive_name(rs.getString("receive_name"));
								r.setUser_id(rs.getInt("user_id"));
								receiveaddress.add(r);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							DbUtil.closeConnection();
						}
						return receiveaddress;

					}
				public void modifyByReceiveaddress(ReceiveAddress r,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_receive_address set full_address=?,mobile=?,phone=?,postal_code=?," +
							"receive_name=?,user_id=?,id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, r.getFull_address());
						ps.setString(2, r.getMobile());
						ps.setString(3, r.getPhone());
						ps.setString(4, r.getPostal_code());
						ps.setString(5, r.getReceive_name());
						ps.setInt(6, r.getUser_id());
						ps.setInt(7, r.getId());
						ps.setInt(8, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addReceiveaddress(ReceiveAddress r) throws Exception {
					Connection conn = null;
					String sql = "insert into d_receive_address(full_address,mobile,phone,postal_code," +
							"receive_name,user_id,id) value(?,?,?,?,?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, r.getFull_address());
						ps.setString(2, r.getMobile());
						ps.setString(3, r.getPhone());
						ps.setString(4, r.getPostal_code());
						ps.setString(5, r.getReceive_name());
						ps.setInt(6, r.getUser_id());
						ps.setInt(7, r.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delReceiveaddressById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_receive_address where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
//文件表
				public List<UpFile> UpfileFindAll(int page,int pagesize) throws Exception {
						Connection conn = null;
						String sql = "select * from d_upfile order by id desc limit ?,?";
						List<UpFile> upfile=new ArrayList<UpFile>();
						try {
							conn = DbUtil.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, (page-1)*pagesize);
							ps.setInt(2, pagesize);
							ResultSet rs = ps.executeQuery();
							while(rs.next()){
								UpFile up=new UpFile();
								up.setAddtime(rs.getDate("addtime"));
								up.setContenttype(rs.getString("contenttype"));
								up.setFilename(rs.getString("filename"));
								up.setFiletype(rs.getString("filetype"));
								up.setId(rs.getInt("id"));
								up.setUserid(rs.getInt("userid"));
								upfile.add(up);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							DbUtil.closeConnection();
						}
						return upfile;

					}
				public void modifyByUpfile(UpFile up,int oldid) throws Exception {
					Connection conn = null;
					String sql = "update d_upfile set addtime=?,contenttype=?,filename=?,filetype=?," +
							"userid=?,id=? where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setDate(1, up.getAddtime());
						ps.setString(2, up.getContenttype());
						ps.setString(3, up.getFilename());
						ps.setString(4, up.getFiletype());
						ps.setInt(5, up.getUserid());
						ps.setInt(6, up.getId());
						ps.setInt(7, oldid);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void addUpfile(UpFile up) throws Exception {
					Connection conn = null;
					String sql = "insert into d_upfile(addtime,contenttype,filename,filetype," +
							"userid,id) value(?,?,?,?,?,?)";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setDate(1, up.getAddtime());
						ps.setString(2, up.getContenttype());
						ps.setString(3, up.getFilename());
						ps.setString(4, up.getFiletype());
						ps.setInt(5, up.getUserid());
						ps.setInt(6, up.getId());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}
				public void delUpfileById(int id) throws Exception {
					Connection conn = null;
					String sql = "delete from d_upfile where id=?";
					try {
						conn = DbUtil.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DbUtil.closeConnection();
					}
					
				}		
}
