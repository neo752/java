<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<style>
.tab {

	}
	.menurow1{
	border-left:3px solid #d8e4c6;
	border-right:3px solid #666;
	border-bottom:3px solid #888496;
	border-top:3px solid #e9e6e6;
	color:#000;
	background-color:#d8e4c6;
	padding:1px 10px;
	margin:1px 2px;
	display:inline;
	float:right;
	width:10%;
	height:25px;
	text-align:center;
	position:relative;
	top:3px;
	cursor:pointer;
	}
	.menurow1 A:link{
	text-decoration:none;
	}
	.menurow1 A:visited{
	text-decoration:none;
	}
	.menurow1 A:hover{
	text-decoration:none;
	}
	.menurow1 A:active{
	text-decoration:none;
	}
	a{text-decoration:none;}
	.menurow2{
	border:1px solid #FFF;
	color:#000;
	background-color:#ffaa55;
	padding:1px 10px;
	margin:1px 2px;
	display:inline;
	float:right;
	width:8%;
	height:25px;
	text-align:center;
	top:3px;
	}
	*{
	border-radius:5px;
	-moz-border-radius:5px;
	-khtml-border-radius:5px;
	-webkit-border-radius:5px;
	}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
		var buytime;
		var buybutton;
	$(function() {
		$("#cartnum").load("cartnum");
		//退出按钮事件
		$("#exitlogin").click(function() {
			longincheck();
		});
		//隐藏个人信息框
		//个人信息框的鼠标移动事件
		$("#headuserinfo").hover(function() {
			$("#info").fadeIn("slow").css("z-index","99999999"); 
		}, function() {
			$("#info").fadeOut("slow"); 

		});
		//菜单鼠标移动事件

		$(".menurow1").hover(function() {		
				$(this).css("background-color","#446655")
				.css("border-left","3px solid #666")
				.css("border-right","3px solid #d8e4c6")
				.css("border-bottom","3px solid #e9e6e6")
				.css("border-top","3px solid #888496");
				$(this).children("a").css("color","#d8e4c6");
				$(this).children("div").hide().slideDown("fast");
		}, function() {
				$(this).css("background-color","#d8e4c6")
				.css("border-left","3px solid #d8e4c6")
				.css("border-right","3px solid #666")
				.css("border-bottom","3px solid #888496")
				.css("border-top","3px solid #e9e6e6");
				$(this).children("a").css("color","#000");
				$(this).children("div").slideUp("fast"); 

		});
		$(".menurow2").hover(function() {		
				$(this).css("background-color","#446655");
				$(this).children("a").css("color","#d8e4c6");
				//$(this).children("a").children("div").hide().slideDown("slow");
		}, function() {
				$(this).css("background-color","#ffaa55");
				$(this).children("a").css("color","#000");
				//$(this).children("a").children("div").slideUp("slow");

		});
		//购物车
	
		$(".buy").click(function(){
			buybutton=$(this);
			var buybuttonhtml=	$(this).html();
			var buynext=$(this).next();
			var id=$(this).attr("id");
			$.post("addcart",{"id":id},
				function(data){
					if(data){
						$("#cartnum").load("cartnum");
						buynext.html("<font color=blue>购买成功！</font>").hide().show(10,function(){
							//myshowdiv();
							buybutton.show(2000,function(){
							buybutton.next().html("");
							});
						});
						buybutton.hide();
					}else{
						buynext.html("<font color=red>商品已在购物车内！</font>").hide().show(10,function(){
						//myshowdiv(); 
							buybutton.hide().show(2000,function(){
								buybutton.next().html("");
							});
						});
						buybutton.hide();
					}
				},"json");
			return false;
		});
			$("#mydang").hover(function(){
						$("#cartaddress").slideDown(200);
					},function(){
						$("#cartaddress").slideUp(200);
					});
				$(".bbbbb").hover(function(){
					$(this).css("background-color","#FFF");
				},function(){
						$(this).css("background-color","#ACB");
			});
	
	});
	

	//退出事件	
	function longincheck() {
		$.post("removeUser",function(check){
				if(!check){
					location="../main/main.jsp";
				}else{
					$("#heada").load('head_category');
				}
		});
			
	}
	function modifycart(num,tdspan){
			$.post("modifycart",{"qtytype":num},function(){
					tdspan.html(tdspan.html()+1);
			});
	}
	
	
</script>
<link href="../css/book_head090107.css" rel="stylesheet" type="text/css" />
<!-- 开始遮挡 -->

<!-- 结束遮挡 -->
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					|<div style="display:inline" id="mydang"> <a href="user_main" name="mydangdang" 
					class="head_black12a">我的当当</a> 
					
					
<div id="cartaddress" style="position: absolute; z-index:9;display:none;">
	 <a href="addressfindall">
	<div class="bbbbb" style="background-color:#ACB;padding: 10px 10px">
		<center>	<img src="../images/second_rmzz.png" width="40px"/><br/>
					我的地址</center>
	</div>	</a>
		 <a href="orderfindall">
	<div class="bbbbb" style="background-color:#ACB;padding: 10px 10px">
		<center><img src="../images/icon_present.gif" width="40px"/><br/>
					我的订单</center>
	</div>	</a>
</div>
</div>
					
					
					| <a href="#" name="helpcenter"
					class="head_black12a" target="_blank">帮助</a> | </span> </span>
			<div class="cart gray4012" id="cartnum" >
			<!-- 购物车 -->
			</div>
		</div>
		<span class="head_toutext" id="logininfo"> <s:if
				test="#session.user!=null">
				<b>您好!欢迎光临当当网&nbsp;&nbsp;&nbsp;&nbsp; [<a href="#"
					id="headuserinfo"><font color=blue><s:property
								value="#session.user.nickname" /> </font> </a> <font color=red>Lv.<s:property
							value="#session.user.user_integral" /> </font>]</b>
		&nbsp;[<a href="#" class="b" id="exitlogin">退出</a>]&nbsp;
		</s:if> <s:else>
				<b>欢迎光临当当网</b>
		[&nbsp;<a href="../user/login_form.jsp" class="b">登录</a>|<a
					href="../user/register_form.jsp" class="b">注册</a>&nbsp;]
			</s:else> </span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="../main/main.jsp"
				name="backtobook"><img src="../images/booksaleimg/book_logo.gif" />
			</a> </span>
		</div>
		<div class="head_head_list_right">
			<div id="info" style="position: absolute;display:none">
				<div>
					<img src="../images/sys/round.png" />
				</div>
				<div
					style="background-color: #fcf188; border: 1px solid #000; width: 200px; height: 100%">
					<h1 style="font-size: 25px;">
						<font size=3px>当当昵称：<br /> <br /> </font>
						<b><s:property value="#session.user.nickname" /> </b>
						<font size=2px color=red>（<b>Lv. <s:property
									value="#session.user.user_integral" /> </b>） </font>
					</h1>
						<br/><div class=line_xx></div><br/>
					<h3>
						邮箱：
					</h3>
					<font size=3px><b><s:property
								value="#session.user.email" />
					</b>
					</font>
					<br/><br/><div class=line_xx></div><br/>


					<h3>
						最后一次登陆时间：
					</h3>
					<font size=3px><b> <s:date
								name="#session.user.last_login_time"
								format="yyyy年MM月dd日hh:ss:mm" /> </b>
					</font>
						<br/><br/><div class=line_xx></div><br/>
					<h3>
						最后一次登陆IP：
					</h3>
					<font size=3px> <b><s:property
								value="#session.user.last_login_ip" /> </b>
					</font>
						<br/>	<br/>	<div class=line_xx></div><br/>
					<h3>
						邮箱验证状态：
						<font size=3px> <b> <s:property
									value="#session.user.is_email_verify==\"y\"?'已验证':'未验证'" /> </b>
						</font><br/><br/>
					</h3>









				</div>
			</div>
			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>	
	<div  style="background-color:#d8e4c6;">
	

				<s:iterator value="cats"  var="c1">
			<div class="menurow">
				<div class="menurow1" >
			<a href='booklist?pid=${c1.id}&cid=${c1.id}' >
							<b>${c1.name}</b></a>
					<s:iterator value="subCats" var="c2">
							<div style="display:none;position:relative;top:5px;width:100%" class="menurow2">
						<a href='booklist?pid=${c1.id}&cid=${c2.id}'>
						${c2.name}</a>
							</div>
						
					</s:iterator>
				</div>
			
			</div>
				</s:iterator>
				<div class="menurow1" >
				<a href='../main/main.jsp'>
				<b style="color:red;font-size:13px">当当首页</b>
				</a>
				</div>
		<br/>	<br/>	
	</div>
	<div class="head_search_bg"></div>
</div>

