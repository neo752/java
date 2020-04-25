package org.dang.dao.order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dang.dao.OrderDao;
import org.dang.entity.Item;
import org.dang.entity.Order;
import org.dang.entity.ReceiveAddress;
import org.dang.util.DbUtil;

public class OrderDaoImpl implements OrderDao {

	public List<ReceiveAddress> findAllAddressByUserId(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		List<ReceiveAddress> relist = null;
		String sql = "select * from d_receive_address where user_id=?";
		ResultSet rs;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			relist = new ArrayList<ReceiveAddress>();
			while (rs.next()) {
				ReceiveAddress r = new ReceiveAddress();
				r.setReceive_name(rs.getString("receive_name"));
				r.setId(rs.getInt("id"));
				r.setFull_address(rs.getString("full_address"));
				r.setMobile(rs.getString("mobile"));
				r.setPhone(rs.getString("phone"));
				r.setPostal_code(rs.getString("postal_code"));
				r.setUser_id(rs.getInt("user_id"));
				relist.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return relist;
	}

	public List<Order> findAllOrderByUserId(int id) throws Exception {
		Connection conn = null;
		String sql = "select * from d_order where user_id=? ";
		List<Order> order=new ArrayList<Order>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	
	public void AddAddress(ReceiveAddress ra) throws Exception {
		Connection conn = null;
		String sql = "insert into d_receive_address(full_address,mobile,phone,postal_code,"
				+ "receive_name,user_id) value(?,?,?,?,?,?)";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ra.getFull_address());
			ps.setString(2, ra.getMobile());
			ps.setString(3, ra.getPhone());
			ps.setString(4, ra.getPostal_code());
			ps.setString(5, ra.getReceive_name());
			ps.setInt(6, ra.getUser_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}

	}

	public void AddItem(Item i) throws Exception {
		Connection conn = null;
		String sql = "insert into d_item(amount,dang_price,order_id,product_id,"
				+ "product_name,product_num) value(?,?,?,?,?,?)";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, i.getAmount());
			ps.setDouble(2, i.getDang_price());
			ps.setInt(3, i.getOrder_id());
			ps.setInt(4, i.getProduct_id());
			ps.setString(5, i.getProduct_name());
			ps.setInt(6, i.getProduct_num());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}

	}

	public int AddOrder(Order o) throws Exception {
		Connection conn = null;
		int num = 0;
		String sql = "insert into d_order(full_address,mobile,order_desc,order_time,phone,postal_code,"
				+ "receive_name,status,total_price,user_id) value(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
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
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			num = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		return num;
	}

	public List<Item> findAllItemByOrderId(int id) throws Exception {
			Connection conn = null;
			String sql = "select * from d_item where order_id=?";
			List<Item> item=new ArrayList<Item>();
			try {
				conn = DbUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
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

	public void delAddressById(int id) throws Exception {
		Connection conn = null;
		String sql = "delete from d_receive_address where id=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection();
		}
		
	}
}
