<%@page contentType="text/html;charset=utf-8" import="org.dang.service.*,org.dang.service.user.*"%>
<%UserService uservice=new UserServiceImpl(); %>
<%@include file="../common/taglib.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
		<script type="text/javascript">
	var checkimg = false;
	var checkemail = false;
	var checkname = false;
	var checkpwd = false;
	var checkrepwd = false;
	$(function() {
		//更换验证码点击事件
		$("#change").click(function() {
			img_re();
		});
		//更换验证码的图片点击事件
		$("#imghref").click(function() {
			img_re();
		});
		//验证码的焦点离开事件
		$("#txtVerifyCode").blur(function() {
			img_check();
		});
		//Email的焦点离开事件
		$("#txtEmail").blur(function() {
			txtEmail_check();
		});
		//昵称的焦点离开事件
		$("#txtNickName").blur(function() {
			txtNickName_check();
		});
		//密码的焦点离开事件
		$("#txtPassword").blur(function() {
			txtPassword_check();
		});
		//重复密码的焦点离开事件
		$("#txtRepeatPass").blur(function() {
			txtRepeatPass_check();
		});
		//表单提交验证
		$("#formsubmit").submit(
				function() {
					if(checkimg && checkemail && checkname && checkpwd
							&& checkrepwd){
					return true;
					}else{
				img_check();
				txtEmail_check();
				txtNickName_check();
				txtPassword_check();
				txtRepeatPass_check();
				return false;
					}
				
				});
	});
	var ok = "<img src='../images/sys/server_ok.gif'><font color=blue>";
	var error = "<img src='../images/sys/warning.gif'><font color=red>";
	//验证码图片重新发送
	function img_re() {
		$("#imgVcode").attr("src", "image?dt=" + new Date());
	}
	//验证码验证
	function img_check() {
		var codeText = $("#txtVerifyCode").val();
		$("#vcodeValidMsg").css("backgroundColor","#fff");
		if (codeText == "") {
			$("#vcodeValidMsg").html(error + "请输入验证码</font>")
			.css("backgroundColor","#f5e5c8");
			checkimg = false;
			return;
		}
		$.post("checkcode", {
			"code" : codeText
		}, function(data) {
			if (data) {
				$("#vcodeValidMsg").html(ok + "验证码OK</font>");
				checkimg = true;
				return;
			} else {
				$("#vcodeValidMsg").html(error + "验证码错误！请重新输入！</font>")
					.css("backgroundColor","#f5e5c8");
				checkimg = false;
				return;
			}
		});
	}
	//邮箱验证
	function txtEmail_check() {
		var reg = /^([\w_\.\-])+\@(([\w\-])+\.)+(\w{2,4})+$/;
		var u = $("#txtEmail").val();
		var m = $("#emailValidMsg");
		m.html(ok).css("backgroundColor","#fff");
		if (u == "") {
			m.html(error + "邮箱不能为空！</font>")
			.css("backgroundColor","#f5e5c8");
			checkemail = false;
			return;
		}
		if (!reg.test(u)) {
			m.html(error + "请填写有效的Email地址，<br>在下一步中您将用此邮箱接收验证邮件。</font>")
				.css("backgroundColor","#f5e5c8");
			checkemail = false;
			return;
		}

		m.html("<img src='../images/sys/window_loading.gif'>正在检测邮箱...</font>");
		$.post("checkemail", {
			"user.email" : u
		}, function(data) {
			if (data) {
				m.html(ok + "此邮箱可以使用！</font>");
				checkemail = true;
				return;
			} else {
				m.html(error + "此邮箱已存在！</font>")
			.css("backgroundColor","#f5e5c8");
				checkemail = false;
				return;
			}
		});
	}
	//昵称验证
	function txtNickName_check() {
		var u = $("#txtNickName").val();
		var m = $("#nickNameValidMsg");
		m.html(ok)
			.css("backgroundColor","#fff");
		if (u == "") {
			m.html(error + "昵称不能为空！</font>")
			.css("backgroundColor","#f5e5c8");
			checkname = false;
			return;
		}
		if (u.length<=0||u.length>=11) {
			m.html(error
					+ "您的昵称可以由小写英文字母、中文、数字组成，<br>长度1－10个字符。</font>")
			.css("backgroundColor","#f5e5c8");
			checkname = false;
			return;
		}

		m.html("<img src='../images/sys/window_loading.gif'>正在检测昵称...</font>");
		$.post("checknickname", {
			"user.nickname" : u
		}, function(data) {
			if (data) {
				m.html(ok + "此昵称可以使用！</font>");
				checkname = true;
				return;
			} else {
				m.html(error + "此昵称已存在！</font>")
			.css("backgroundColor","#f5e5c8");
				checkname = false;
				return;
			}
		});
	}
	//密码验证
	function txtPassword_check() {
		var reg = /^[a-zA-Z\d+]{6,20}$/;
		var pwd = $("#txtPassword").val();
		var pwdMsg = $("#passwordValidMsg");
		pwdMsg.html(ok)
			.css("backgroundColor","#fff");
		if (pwd == "") {
			pwdMsg.html(error + "密码不能为空！</font>")
			.css("backgroundColor","#f5e5c8");
			checkpwd = false;
			return;
		}
		if (!reg.test(pwd)) {
			pwdMsg.html(error + "您的密码可以由大小写英文字母、数字组成，长度6－20位。</font>")
			.css("backgroundColor","#f5e5c8");
			checkpwd = false;
			return;
		}
			pwdMsg.html(ok + "此密码可以使用！</font>");
			checkpwd = true;
	}
	//重复密码验证
	function txtRepeatPass_check() {
		var pwd = $("#txtPassword").val();
		var repwd = $("#txtRepeatPass").val();
		var pwdMsg = $("#repeatPassValidMsg");
		pwdMsg.html(ok)
			.css("backgroundColor","#fff");
		if (repwd == "") {
			pwdMsg.html(error + "重复密码不能为空！</font>")
			.css("backgroundColor","#f5e5c8");
			checkrepwd = false;
			return;
		}
		if (pwd != repwd) {
			pwdMsg.html(error + "两次密码必须相同。</font>")
			.css("backgroundColor","#f5e5c8");
			checkrepwd = false;
			return;
		}
		checkrepwd = true;
	}
</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> ＞ 2.验证邮箱 ＞ 3.注册成功
		</div>
		<div class="fill_message">
			<form method="post" action="regist" id="formsubmit">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							当前IP：
						</td>
						<td>  	
							<input style="color:#000;font-size:13px" type="text" class="text_input"
									disabled="disabled" value="<%=uservice.getIpAddr(request)%>"/>
							<input type="hidden" value="<%=uservice.getIpAddr(request)%>"
									name="user.last_login_ip" />
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input type="text" name="user.email" id="txtEmail" class="text_input" />
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，
									<br />
									在下一步中您将用此邮箱接收验证邮件。
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input type="text" name="user.nickname" id="txtNickName"
								class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
									<br />
									长度1－10个字符。
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input type="password" name="user.password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input type="password" name="password1" id="txtRepeatPass"
								class="text_input" />
							<div class="text_left" id="repeatPassValidMsg">
								两次密码必须相同。
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<a href="#" id="imghref"><img class="yzm_img" id='imgVcode'
									src="image" /> </a>
							<input name="txtVerifyCode" type="text" id="txtVerifyCode"
								class="yzm_input" />
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的结果。</span>
									<br />
									<a id="change" href="#">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<input type="submit" id="btnClientRegister" class="button_1"
						value="注 册" />
					<span id="submitmsg"></span>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

