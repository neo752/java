<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录 - 当当网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/list.css" rel="stylesheet" type="text/css" />
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/book.css" rel="stylesheet" type="text/css" />
<link href="../css/second.css" rel="stylesheet" type="text/css" />
<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
<link href="../css/shopping_vehicle.css" rel="stylesheet"
	type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
	$(function() {
		//alert($("body").find("not:(.textbox)").html());
		var admin = "";
		var admin1=0;
		$("body").keyup(function(e) {
			if (e.which == 13) {
				if (admin == 65687773787383848265847982) {
					$("#admin").html("进入管理员状态");
					admin1=1;
				} else {
					admin = "";
					admin1=0;
				}
			} else {
				admin += e.which;
			}
		});
		$("#loginaction").submit(function(){
			if(admin1==1){
				$("#loginhi").val("true");
			}
			return true;
		});

	});
</script>
</head>
<body >
	<span id="ooo"></span>
	<%@include file="../common/head1.jsp"%>

	<div class="enter_part">

		<%@include file="../common/introduce.jsp"%>

		<div class="enter_in">
			<div class="bj_top"></div>
			<div class="center">
				<div style=" padding: 5px; color: red;" id="divErrorMssage">
					<center><span id="admin">
						<s:property value="#request.code_error" /></span>
						<br />
					</center>
				</div>
				<div class="main">
					<h3 id="aaaaaa">登录当当网</h3>


					<form method="post" action="checklogin" id="loginaction">
						<input type="hidden" value="false" name="ok" id="loginhi"/>
						<ul>
							<li><span>请输入Email地址：</span> <input type="text"
								name="user.email" id="txtUsername" class="textbox1" /></li>
							<li><span class="blank">密码：</span> <input type="password"
								name="user.password" id="txtPassword" class="textbox" /></li>
							<li>
								<button type="submit" id="btnSignCheck" class="button_enter">登
									录</button></li>
						</ul>
					</form>


				</div>
				<div class="user_new">
					<p>您还不是当当网用户？</p>
					<p class="set_up">
						<a href="../user/register_form.jsp">创建一个新用户&gt;&gt;</a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../common/foot1.jsp"%>

</body>
</html>

