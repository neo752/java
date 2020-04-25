<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
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
		$(function(){
			timeredir();
		});
		var time1;
		function timeredir(){
				var s=5;
			time1=setInterval(function(){
				if(s>0){
				$("#redirect").html("")
					$("#span1").html("还剩<font color=red>"+s+"</font>秒可以重发！");
					s--;
				}else{
					clearInterval(time1);
					redirectcode();
				}
				},1000);
		}
		//设置重发
		function redirectcode(){
		$("#span1").html("您现在可以：");
			$("#redirect").html("重发验证码").click(function(){
					clearInterval(time1);
				$.post("redirectcode");
				timeredir();
			});
		}
		
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤: 1.填写信息 ＞
			<span class="red_bold">2.验证邮箱</span>＞ 3.注册成功
		</div>
		<form action="registerTwo" method="post">
			<div class="validate_email">
				<h2>
					<input type="hidden" value="${user.nickname}" name="user.nickname" />
					感谢[
					<font size=8px color=#9b7df0>${user.nickname}</font>] 注册当当网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件!
					邮件地址为：	<br/>
						<span class="red">
						<span id="lblEmail" style="color:#9b7df0;font-size:45px">
						<b>${user.email}</b></span>
							<input type="hidden" value="${user.email}" name="user.email" /> </span>
						<span class="t1"> <br/> <br/>请登录您的邮箱收信。</span>
						<span class="t1" id="span1">还剩<font color=red>60</font>秒可以重发！</span><a href="#" id="redirect"></a> 
					</div><br/><br/><br/><br/>
					<h4>
						第二步：输入验证码
						<span><input value="${user.email_verify_code}" style="width:300px"/></span>
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的验证码：</span>
						<input type="text" name="user.email_verify_code" id="validatecode"
							class="yzm_text" size="20" style="width:300px"/>

						<button type="submit" class="finsh" id="Button1">
							完 成
						</button>

						<span id="register1_validatenull" class="no_right">
						 <s:if	test="#request.code_error!=null">
								<s:property value="#request.code_error" />
						</s:if>  </span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

