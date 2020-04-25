package org.dang.entity;

import java.sql.Date;

public class User {
	private int id, user_integral;
	private String is_email_verify,email, nickname, password, email_verify_code, last_login_ip;
	private Date last_login_time;

	


	public int getUser_integral() {
		return user_integral;
	}

	public void setUser_integral(int userIntegral) {
		user_integral = userIntegral;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getIs_email_verify() {
		return is_email_verify;
	}

	public void setIs_email_verify(String isEmailVerify) {
		is_email_verify = isEmailVerify;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date lastLoginTime) {
		last_login_time = lastLoginTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_verify_code() {
		return email_verify_code;
	}

	public void setEmail_verify_code(String emailVerifyCode) {
		email_verify_code = emailVerifyCode;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String lastLoginIp) {
		last_login_ip = lastLoginIp;
	}

}
