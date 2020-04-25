package org.dang.action.user;

import java.sql.Date;

import org.dang.action.BaseAction;
import org.dang.dao.UserDao;
import org.dang.dao.user.UserDaoImpl;
import org.dang.entity.User;
import org.dang.service.UserService;
import org.dang.service.user.UserServiceImpl;
import org.dang.util.Constant;
import org.dang.util.MD5;
import org.dang.util.VerifyUtil;

public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private User user;
	private boolean ok;
	private String ippath;

	// 注册用户写入信息
	public String regist() throws Exception {
		UserService uservice=new UserServiceImpl();
		String code = VerifyUtil.uuid();
		user.setUser_integral(Constant.NORMAL);// 等级为0
		user.setEmail_verify_code(code);// 设置邮箱验证码
		user.setIs_email_verify(Constant.NO);// 设置邮箱验证状态为no
		user.setLast_login_ip(uservice.getIpAddr(request));// 设置登陆IP
		Date date = new Date(System.currentTimeMillis());
		user.setLast_login_time(date);// 设置登陆时间
		user.setPassword(MD5.md5(user.getPassword()));// 加密密码
		UserDao uDao = new UserDaoImpl();
		uDao.addUser(user);
		// 将user放入session
		UserService us = new UserServiceImpl();
		user = us.findUserByEmail(user.getEmail(), request.getRemoteAddr());
		user.setLast_login_time(user.getLast_login_time());
		session.removeAttribute(Constant.SESSION_USER);
		session.removeAttribute(Constant.SESSION_UPFILE);
		session.removeAttribute(Constant.SESSION_CART);
		session.setAttribute(Constant.SESSION_USER, user);
		// 邮箱发送。需要commons-email.jar,email.jar

//		if (session.getAttribute("ippath") == null) {
//			return "verify";
//		} else {
//			ippath = (String) session.getAttribute("ippath");
//			return "back";
//		}
		return "verify";
	}

	// 重发验证码redirectcode
	public String redirectcode() {
		user = (User) session.getAttribute(Constant.SESSION_USER);
		String v = user.getEmail_verify_code();
		System.out.println(user.getEmail() + "邮箱验证码" + v);
		// 邮箱发送。需要commons-email.jar,email.jar

		return "success";
	}

	// 检测邮箱名
	public String checkemail() {
		UserDao udao = new UserDaoImpl();
		try {
			ok = udao.checkEmail(user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 检测昵称
	public String checknickname() {
		UserDao udao = new UserDaoImpl();
		try {
			ok = udao.checkNickname(user.getNickname());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 检测邮箱验证码
	public String checkVerifyCode() {
		UserService us = new UserServiceImpl();
		UserDao udao = new UserDaoImpl();
		try {
			ok = udao.checkVerifyCode(user.getEmail_verify_code(), user
					.getEmail());
			if (ok) {
				user = us.findUserByEmail(user.getEmail(), request
						.getRemoteAddr());
				user.setLast_login_time(user.getLast_login_time());
				session.setAttribute(Constant.SESSION_USER, user);
				
				return "success";
			} else {
				request.setAttribute("code_error", "邮箱验证码错误，请重新输入！");
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 检测用户登陆
	public String checkLogin() {
		UserService us = new UserServiceImpl();
		String check = null;
		try {
				check = us.checkLogin(user.getEmail(), user.getPassword());

				if (check == "success" || check == "checkcode") {
					user = us.findUserByEmail(user.getEmail(), request
							.getRemoteAddr());
					session.removeAttribute(Constant.SESSION_USER);
					session.removeAttribute(Constant.SESSION_UPFILE);
					user.setLast_login_ip(us.getIpAddr(request));// 设置登陆IP
					Date date = new Date(System.currentTimeMillis());
					user.setLast_login_time(date);// 设置登陆时间
					session.setAttribute(Constant.SESSION_USER, user);
					if(ok){
						return "adminter";
					}
				}
				if (check == "false") {
					request.setAttribute("code_error", "用户名或密码错误，请重新输入！");
				}
				return check;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 邮箱更改

	public String emailmodify() {
		UserService us = new UserServiceImpl();
		String email = user.getEmail();
		user = (User) session.getAttribute(Constant.SESSION_USER);
		int id = user.getId();
		try {
			if (us.email_modify(email, id)) {
				user.setEmail(email);
				user.setIs_email_verify(Constant.NO);
				session.setAttribute(Constant.SESSION_USER, user);
				ok = true;
			} else {
				ok = false;
			}
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	// 昵称更改

	public String nicknamemodify() {
		UserService us = new UserServiceImpl();
		String nickname = user.getNickname();
		user = (User) session.getAttribute(Constant.SESSION_USER);
		int id = user.getId();
		try {
			if (us.nickname_modify(nickname, id)) {
				user.setNickname(nickname);
				session.setAttribute(Constant.SESSION_USER, user);
				ok = true;
			} else {
				ok = false;
			}
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	// 检测密码
	public String pwd_check() {
		UserDao udao = new UserDaoImpl();
		String pwd = MD5.md5(user.getPassword());
		user = (User) session.getAttribute(Constant.SESSION_USER);
		try {
			ok = udao.checkPwd(pwd, user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	// 修改密码
	public String pwdmodify() {
		UserDao udao = new UserDaoImpl();
		String pwd = MD5.md5(user.getPassword());
		user = (User) session.getAttribute(Constant.SESSION_USER);
		try {
			ok = udao.modfyPwd(pwd, user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getIppath() {
		return ippath;
	}

	public void setIppath(String ippath) {
		this.ippath = ippath;
	}

}
