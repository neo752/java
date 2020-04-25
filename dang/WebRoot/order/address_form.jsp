<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
	$(function(){
		$("#address").change(function(){
			var val=$("#address option:checked").val();
			if(val=="填写新地址"){
				$("#addresswrite").val("1");
				$("#fullAddress").prev().remove();
				$("#fullAddress").attr("name","radd.full_address");
				$("#fullAddress").removeAttr("disabled");
				$("#fullAddress").css("color","#000").css("background-color","#FFF");
				$("#receiveName").val("");
				$("#fullAddress").val("");
				$("#postalCode").val("");
				$("#phone").val("");
				$("#mobile").val("");
			return;
			}
			$("#addresswrite").val("0");
			$("#fullAddress").prev().remove();
			$("#fullAddress").attr("name","");
			$("#fullAddress").attr("disabled","disabled");
			$("#fullAddress").before("<input type='hidden' name='radd.full_address' value='"
					+$("#fullAddress"+val).val()+"'>"); 
			$("#fullAddress").css("color","#000").css("background-color","#CCC");
			$("#receiveName").val($("#receiveName"+val).val());
			$("#fullAddress").val($("#fullAddress"+val).val());
			$("#postalCode").val($("#postalCode"+val).val());
			$("#phone").val($("#phone"+val).val());
			$("#mobile").val($("#mobile"+val).val());
		});
		
		$(":input[type=text]").blur(function(){
			blurcheck($(this));
		});
		$('#formsub').submit(function(){
			var textinput=$(":input[type=text]");
			var blog=true;
			for(var i=0;i<textinput.length;i++){
				if(textinput.eq(i).val()==""){
					blog=false;}
				}
			return blog;
		});
});
		function blurcheck(obj){
			if(obj.val()==""){
				obj.parent("td").children("div").css("display","inline")
				.html("不能为空！");
			}else{
				obj.parent("td").children("div").css("display","inline")
				.html("正确！")
			}
		}
</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 》
			<span class="red_bold"> 2.填写送货地址</span> 》 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address">
					<option>
						填写新地址
					</option>
					<s:iterator value="relist" status="s">
					<option value="${s.count}">
						${receive_name}:${full_address}
					</option>
					</s:iterator>
				</select>
			</p>
			<form  method="post" action="order_ok" id="formsub">
				<input type="hidden" name="addresswrite" id="addresswrite" value="1"/>

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="radd.receive_name"
								id="receiveName" />
								<s:iterator value="relist" status="s">
							<input type="hidden" id="receiveName${s.count}" value="${receive_name}"/>
							</s:iterator>
							<div class="text_left" id="nameValidMsg" style="display:none;color:red">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="radd.full_address" class="text_input"
								id="fullAddress" />
								<s:iterator value="relist" status="s">
							<input type="hidden" id="fullAddress${s.count}" value="${full_address}"/>
							</s:iterator>
							<div class="text_left" id="addressValidMsg" style="display:none;color:red">
								<p >
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="radd.postal_code"
								id="postalCode" />
								<s:iterator value="relist" status="s">
							<input type="hidden" id="postalCode${s.count}" value="${postal_code}"/>
							</s:iterator>
							<div class="text_left" id="codeValidMsg" style="display:none;color:red">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="radd.phone"
								id="phone" />
								<s:iterator value="relist" status="s">
							<input type="hidden" id="phone${s.count}" value="${phone}"/>
							</s:iterator>
							<div class="text_left" id="phoneValidMsg" style="display:none;color:red">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="radd.mobile"
								id="mobile" />
								<s:iterator value="relist" status="s">
							<input type="hidden" id="mobile${s.count}" value="${mobile}"/>
							</s:iterator>
							<div class="text_left" id="mobileValidMsg" style="display:none;color:red">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="orderinfo"><input  class="button_1" 
					type="button" value="取消" /></a>
			
				<input  class="button_1" 
					type="submit" value="下一步" id="nextsub"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

