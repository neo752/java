package org.dang.service;

import javax.servlet.http.HttpServletRequest;

import org.dang.entity.User;



public interface UserService {
	public String getIpAddr(HttpServletRequest request)throws Exception;
	public String checkLogin(String email,String pwd)throws Exception;
	public User findUserByEmail(String email,String ip)throws Exception;
	public boolean email_modify(String email,int id)throws Exception;
	public boolean nickname_modify(String nickname,int id) throws Exception;
}
