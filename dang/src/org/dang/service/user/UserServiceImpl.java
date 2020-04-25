package org.dang.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.dang.dao.UserDao;
import org.dang.dao.user.UserDaoImpl;
import org.dang.entity.User;
import org.dang.service.UserService;
import org.dang.util.MD5;


public class UserServiceImpl  implements UserService {
	private User user;
	List<User> ulist;
	UserDao udao = new UserDaoImpl();
	//获得请求真实IP，包括中转代理后也可得到起始IP
    public String getIpAddr(HttpServletRequest request) throws Exception{
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
        // 多次反向代理后会有多个IP值，第一个为真实IP。
        int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
        	if(request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")){
        		return "127.0.0.1";
        	}
             return request.getRemoteAddr();
        }
    }
	public String checkLogin(String email, String pwd) {
		int check = 0;
		ulist = new ArrayList<User>();
		try {
			check = udao.checkLogin(email, MD5.md5(pwd));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		if (check == 1) {
			return "success";
		} else if (check == 2) {
			return "false";
		} else {
			return "checkcode";
		}
	}

	public User findUserByEmail(String email,String ip) throws Exception{
		try {
			user = udao.findAllByEmail(email,ip);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
	}

	public boolean email_modify(String email,int id) throws Exception {
		try {
			return udao.email_modify(email,id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean nickname_modify(String nickname,int id) throws Exception {
		try {
			return udao.nickname_modify(nickname,id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

}
