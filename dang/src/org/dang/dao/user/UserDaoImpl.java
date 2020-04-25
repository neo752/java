package org.dang.dao.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dang.dao.UserDao;
import org.dang.entity.User;
import org.dang.util.Constant;
import org.dang.util.DbUtil;





public class UserDaoImpl implements UserDao {

	public boolean checkEmail(String email) throws Exception {
		Connection conn = null;
		String sql = "select email from d_user where email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			if (ps.executeQuery().next()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return true;
	}
	public boolean checkPwd(String pwd,String email) throws Exception {
		Connection conn = null;
		String sql = "select email from d_user where password=? and email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, email);
			if (ps.executeQuery().next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return false;
	}
	public boolean modfyPwd(String pwd,String email) throws Exception {
		Connection conn = null;
		String sql = "update d_user set password=? where email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, email);
			if (ps.executeUpdate()==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return false;
	}
	
	
	public boolean checkNickname(String nickname) throws Exception {
		Connection conn = null;
		String sql = "select nickname from d_user where nickname=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nickname);
			if (ps.executeQuery().next()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return true;
	}

	public boolean checkVerifyCode(String code, String email) throws Exception {
		Connection conn = null;
		String sql = "select email_verify_code from d_user where email_verify_code=? and email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, email);
			if (ps.executeQuery().next()) {
				sql = "update d_user set is_email_verify=? where email=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Constant.YES);
				ps.setString(2, email);
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return false;
	}

	public int checkLogin(String email, String password) throws Exception {
		Connection conn = null;
		String sql = "select is_email_verify from d_user where password=? and email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("is_email_verify").equals("n")) {
					return 3;
				} else {
					return 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			DbUtil.closeConnection();
		}
		return 2;
	}

	public void addUser(User user) throws Exception {
		Connection conn = null;
		String sql = "insert into d_user(email,nickname,password,email_verify_code,last_login_time,last_login_ip,user_integral,is_email_verify) "
				+ "value(?,?,?,?,?,?,?,?)";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getNickname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail_verify_code());
			long time=user.getLast_login_time().getTime();
			ps.setLong(5, time);
			ps.setString(6, user.getLast_login_ip());
			ps.setInt(7, user.getUser_integral());
			ps.setString(8, user.getIs_email_verify());
			System.out.println(user.getEmail() + "的邮箱验证码" + user.getEmail_verify_code());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}

	}

	public List<User> findAll() throws Exception {
		Connection conn = null;
		String sql = "select * from d_user";
		List<User> user=new ArrayList<User>();
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public User findAllByEmail(String email,String ip) throws Exception {
		Connection conn = null;
		User u=new User();
		String sql = "select * from d_user where email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				u.setEmail(rs.getString("email"));
				u.setEmail_verify_code(rs.getString("email_verify_code"));
				u.setId(rs.getInt("id"));
				u.setIs_email_verify(rs.getString("is_email_verify"));
				u.setLast_login_ip(rs.getString("last_login_ip"));
				Date date=new Date(rs.getLong("last_login_time"));
				u.setLast_login_time(date);
				u.setNickname(rs.getString("nickname"));
				u.setUser_integral(rs.getInt("user_integral"));
			}
			sql="update d_user set last_login_time=?,last_login_ip=? where email=?;";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, System.currentTimeMillis());
			ps.setString(2, ip);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return u;

	}

	public boolean email_modify(String email,int id) throws Exception {
		Connection conn = null;
		String sql = "select * from d_user where email=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return false;
			}
			sql="update d_user set email=?,is_email_verify=? where id=?;";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Constant.NO);			
			ps.setInt(3, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return false;
	}
	public boolean nickname_modify(String nickname,int id) throws Exception {
		Connection conn = null;
		String sql = "select * from d_user where nickname=?";
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nickname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return false;
			}
			sql="update d_user set nickname=? where id=?;";
			ps=conn.prepareStatement(sql);
			ps.setString(1, nickname);			
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return false;
	}
	
	
}
