package org.dang.dao;

import java.util.List;

import org.dang.entity.User;





public interface UserDao {
	public boolean checkEmail(String email)throws Exception;
	public boolean checkNickname(String nickname)throws Exception;
	public boolean checkVerifyCode(String code,String email) throws Exception;
	public void addUser(User user)throws Exception;
	public int checkLogin(String email,String password)throws Exception;
	public User findAllByEmail(String email,String ip)throws Exception;
	public List<User> findAll() throws Exception;
	public boolean email_modify(String email,int id)throws Exception;
	public boolean checkPwd(String pwd,String email) throws Exception;
	public boolean modfyPwd(String pwd,String email) throws Exception;
	public boolean nickname_modify(String nickname,int id) throws Exception;
}
