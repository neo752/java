package org.dang.dao.cart;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.dang.dao.CartDao;
import org.dang.entity.Product;
import org.dang.util.DbUtil;



public class CartDaoImpl implements CartDao{

	public Product findAllProductById(int id) throws Exception {
		Connection conn = null;
		String sql = "select * from d_product where id=?";
		Product p=null;
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				p=new Product();
				p.setAddtime(new Date(rs.getLong("add_time")));
				p.setDang_price(rs.getDouble("dang_price"));
				p.setDescription(rs.getString("description"));
				p.setFixed_price(rs.getDouble("fixed_price"));
				p.setHas_deleted(rs.getInt("has_deleted"));
				p.setId(rs.getInt("id"));
				p.setKeywords(rs.getString("keywords"));
				p.setProductname(rs.getString("product_name"));
				p.setProductpic(rs.getString("product_pic"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return p;
	}
	
}
