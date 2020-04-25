<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
	<!-- 下面为长字符自动变短并加...效果
		white-space:nowrap;
		text-overflow:ellipsis;
		-o-text-overflow:ellipsis;
		overflow:hidden;
	 -->
<style>
#parentdiv {
	position: fixed;
	top: 0px;
	left: 0px;
	z-index: 200001;
	background-color: #000;
	opacity: 0.5;
}

#div0 {
	width: 500px;
	height: 300px;
	position: absolute;
	background-color: #fff;
	z-index: 200002;
	top: 200px;
	left: 0px;
	border-bottom: 5px solid #333;
	border-left: 5px solid #EEE;
	border-right: 5px solid #666;
	border-top: 5px solid #AAA;
}
</style>
<script type="text/javascript" src="../js/jquery-1.7.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/myjs.js"></script>
<script type="text/javascript">
	$(function() {
		$("#divlv").hide();
		$("#lv").toggle(function() {
			$("#lvimg").attr("src", "../images/button_down2.gif");
			$("#divlv").slideDown("slow");
		}, function() {
			$("#lvimg").attr("src", "../images/button_down1.gif");
			$("#divlv").slideUp("slow");
		});

	});
	$(function() {

		//邮箱修改按钮点击
		$("#emailM").click(
				function() {
					var content = prompt("邮箱修改", "${session.user.email}");
					var reg = /^([\w_\.\-])+\@(([\w\-])+\.)+(\w{2,4})+$/;
					if (content == "") {
						$("#email_msg").html("邮箱不能为空！");
						return;
					}
					if (!reg.test(content)) {
						$("#email_msg").html("请填写有效Email地址");
						return;
					}
					$("#email_msg").html("");
					$.post("checkemail", {
						"user.email" : content
					}, function(data) {
						if (data) {
							var blog = confirm(content
									+ "邮箱OK!!\n－－－－确定［修改］吗？－－－－");
							if (blog) {
								//邮箱修改
								$.post("email_modify", {
									"user.email" : content
								}, function(data) {
									if (data) {
										alert("邮箱已被更改!!请记住它：\n－－［" + content
												+ "］－－\n最重要的是你需要重新验证你的邮箱！");
										location.reload();
										return;
									} else {
										alert("你手慢了。［" + content + "］已被人抢走!!");
										$("#email_msg").html("请重新点击修改！");
										return;
									}
								});
							}
							return;
						} else {
							alert("［" + content + "］已存在!!");
							$("#email_msg").html("你输入的邮箱已存在，请重新修改！");
							return;
						}
					});
				});
				
					
		$("#nicknameM").click(function(){
					var content = prompt("昵称修改", "${session.user.nickname}");
					if (content == "") {
						$("#nick_msg").html("昵称不能为空！");
						return;
					}
					if (content.length<=0||content.length>=11) {
						$("#nick_msg").html("请填写有效昵称！");
						return;
					}
					$("#nick_msg").html("");
					$.post("checknickname", {
						"user.nickname" : content
					}, function(data) {
						if (data) {
							var blog = confirm(content
									+ "昵称OK!!\n－－－－确定［修改］吗？－－－－");
							if (blog) {
								//邮箱修改
								$.post("nickname_modify", {
									"user.nickname" : content
								}, function(data) {
									if (data) {
										alert("昵称已被更改!!请记住它：\n－－［" + content
												+ "］－－");
										location.reload();
										return;
									} else {
										alert("你手慢了。［" + content + "］已被人抢走!!");
										$("#nick_msg").html("请重新点击修改！");
										return;
									}
								});
							}
							return;
						} else {
							alert("［" + content + "］已存在!!");
							$("#email_msg").html("你输入的邮箱已存在，请重新修改！");
							return;
						}
					});
		});

		//选项鼠标移动事件
		$(".pro").hover(function() {
			$(this).css("background-color", "#F6ED8A ");
		}, function() {
			$(this).css("background-color", "#FFF");

		});
		//初始隐藏DIV
		$("#parentdiv").hide();
		$("#div0").hide();
		//密码修改页面关闭按钮事件
		$("#exita").click(function() {
			$("#parentdiv").slideUp("slow");
			$("#div0").slideUp("slow");
		});
		//密码修改按钮弹出DIV

		$("#pwdM").click(
				function() {
					$("#oldpwd").val("");
					$("#newpwd").val("");
					$("#renewpwd").val("");
						$("#renew_msg").html("");
						$("#new_msg").html("");
						$("#old_msg").html("");
					var winw = self.innerWidth;
					var winh = self.innerHeight;
					$("#parentdiv").css("height", winh).css("width", winw)
							.fadeIn("slow");
					$("#div0").css("left",((winw / 2 - parseInt($("#div0").css("width")) / 2))+ "px").fadeIn("slow");
				});
		//密码修改
		//设置输入框事件
		var ok = "<img src='../images/sys/server_ok.gif' style='display:inline;'><font color=blue>";
		$("#oldpwd").blur(function() {
			pwdcheck1($(this));
		});
		$("#newpwd").blur(function() {
			pwdcheck2($(this));
		});
		$("#renewpwd").keyup(function() {
			pwdcheck3($(this));
		});
		//定义公用正则
		function pwd(pwdMsg, pwd) {
			pwdMsg.html("");
			if (pwd == "") {
				pwdMsg.html("密码不能为空！");
				return false;
			}
			var reg = /^[a-zA-Z\d+]{6,20}$/;
			if (!reg.test(pwd)) {
				pwdMsg.html("密码由大小写英文字母、数字组成，长度6－20位");
				return false;
			}
			return true;
		}
		//公共变量
		var pwd1 = false;
		var pwd2 = false;
		var pwd3 = false;
		var pwdmodify;
		//定义各输入框正则
		function pwdcheck1(p) {
			if (pwd($("#old_msg"), p.val())) {
				$.post("pwd_check", {
					"user.password" : p.val()
				}, function(data) {
					if (data) {
						;
						pwd1 = true;
						$("#old_msg").html(ok);
					} else {
						pwd1 = false;
						$("#old_msg").html("您输入的密码不正确！");
					}
				});
			} else {
				pwd1 = false;
				return;
			}
		}
		function pwdcheck2(p) {
			if (pwd($("#new_msg"), p.val())) {
				pwd2 = true;
				$("#new_msg").html(ok);
			} else {
				pwd2 = false;
				return;
			}
		}
		function pwdcheck3(p) {
			if (pwd($("#renew_msg"), p.val())) {
				if ($("#newpwd").val() != $("#renewpwd").val()) {
					$("#renew_msg").html("请确定两次密码输入相同！");
					pwd3 = false;
					return;
				} else {
					pwdmodify = p.val();
					pwd3 = true;
					$("#renew_msg").html(ok);
				}
			} else {
				pwd3 = false;
				return;
			}
		}
		//提交修改密码申请
		$("#pwdform").submit(function() {
			if (pwd1 && pwd2 && pwd3) {
				$.post("pwd_modify", {
					"user.password" : pwdmodify
				}, function(data) {
					if (data) {
						$("#pwd_msg").html("密码修改成功！");
						autoexita();
						alert("密码修改成功！");
						$("#exita").click();
					} else {
						$("#oldpwd").val("");
						$("#newpwd").val("");
						$("#renewpwd").val("");
						$("#renew_msg").html("");
						$("#new_msg").html("");
						$("#old_msg").html("");
						alert("系统繁忙！请重新申请！");
					}
				});
			}
			return false;
		});

	});

	//遍历图片是否存在，不存在的用未知代替
	$(function() {
		for ( var i = 0; i < $("#tdimg div").length; i++) {
			var s = $("#imgid" + i).attr("class") + "";
			s = s.toLowerCase();
			$.ajax({
				url : "../images/filetype/" + s + ".gif",
				type : "get",
				async : false,
				success : function() {
					$("#imgid" + i).attr("src",
							"../images/filetype/" + s + ".gif");
				},
				error : function() {
					$("#imgid" + i)
							.attr("src", "../images/filetype/weizhi.jpg");
				}
			});
		}

		$("#tdimg div").hover(
				function() {
					$(this).css("background-color", "#EEF").css("overflow",
							"visible").css("border", "1px solid #BBD").css("z-index", "1");
					$(this).children().children().css("display","inline");
				},
				function() {
					$(this).css("background-color", "#FFF").css("overflow",
							"hidden").css("border", "1px solid #FFF").css("z-index", "0");
					$(".imgexit").css("display","none");

				});
				
		$("#upfilesubmit").submit(function(){
			$("#upfilespan").html("");
			if($("#mf").val()==""){
				$("#upfilespan").html("<img src='../images/sys/warning.gif' style='display:inline;width:13px'>未选择上传文件");
				return false;
			}
			return true;
		});
		$("#tdimg div").children("a").click(function(){
			var filename=$(this).children("span").html();
			var img=$(this).children("center").children("img").attr("src");
			myshowdiv("<img src='"+img+"' style='display:inline' width=25px>&nbsp;"
			+filename,"<font color=red>请对<input value='"+filename+"'>进行操作：</font>"
			+"<table style='width:100%;border:3px solid #BBD;background-color:#BCA'><tr><td align='center'><a href='down?fname="
			+filename+"'><img src='../images/sys/down.png' style='width:40px;'>下载</a></td><td align='center'><a href='delupfile?mfFileName="
			+filename+"'><img src='../images/sys/del.png' style='width:40px;'>删除</a></td><td align='center'>"
			+"<a onclick=\"mfn();\" href='modifyfilename?mfFileName="+filename+"&mfContentType="
			+"'><img src='../images/sys/modify.png' style='width:40px;position:relative;'>改名</a></td></tr></table>"
			+"<div><center>图片预览<img src='${pageContext.request.contextPath}/upload/"+filename+"' width=100%></center></div>"
			,"default","default","default","300px","410px","default","#CBA");
		});
		$(".dowhere").hover(function(){
			$(this).css("background-color","#CDE").css("border","1px solid #000"); 
		},function(){
			$(this).css("background-color","#FFF")
			.css("border","1px solid #FFF")
			.css("border-right","1px solid #AAA");  
		});
	
	});
</script>
<input type="hidden" id="hiddenval" >
<!-- div弹出框开始 -->
<div id="parentdiv" style="display:none"></div>

<div id="div0" style="display:none">
	<div id="div1" style="background-color:#7777cc;height:30px;" >
			<font color=#FFF size=4px><b>密码修改</b> </font>
		<a href="javascript:;" id="exita"><img
			src="../images/sys/warning.gif"
			style="position:absolute;top:0px;right:0px;z-index: 200009;" /> </a>
	</div>
	<div id="div2">
		<div style="padding:20px 20px; height:0%;">
			<font size=1px color=red> 注意:你正在试图修改你的密码！<br />
				服务器保存的密码是以MD5加密的形式保存，所以没有人知道你的密码是什<br />
				么，只能以对比的方式进行密码验证。所以请一定保存好你的密码！！</font>
		</div>

		<form action="#" id="pwdform">

			<div
				style="margin:0px 20px;border:1px solid #000;padding:20px 0px 20px 20px;background-color:#DDD;position:relative;">

				<br /> <font size=3px> 旧 密 码 <input type="password"
					id="oldpwd" name="oldpwd" /> <span id="old_msg"
					style="color:red;font-size:10px"> </span> <br /> 新 密 码 <input
					type="password" id="newpwd" name="newpwd" /> <span id="new_msg"
					style="color:red;font-size:10px"> </span> <br /> 确认密码 <input
					type="password" id="renewpwd" name="renewpwd" /> <span
					id="renew_msg" style="color:red;font-size:10px"> </span> </font> <br /> <input
					type="submit" value="提交修改" />

			</div>
		</form>
	</div>
</div>
<!-- div弹出框结束 -->
<h2>用户信息</h2>

<s:if test="#session.user!=null">
<div id=__bianjituijian/danpin style="height: 900px"> 
	<div class=second_c_02>
		<div class=second_c_02_b1 style="height: 250px"> 
			<div class=second_c_02_b1_1>
				<font size=3px>当当昵称：</font><br/><br/><br/>
			<div  style="border:1px solid #FFF;border-right: 1px solid #AAA;padding: 5px 0px" class="dowhere">
				<center><a href="orderfindall">
				<img src="../images/icon_present.gif" width=30px/>我的订单</a></center>
			</div>
			<div  style="border:1px solid #FFF;border-right: 1px solid #AAA;padding: 5px 0px" class="dowhere">
				<center><a href="addressfindall">
				<img src="../images/second_rmzz.png" width=30px/>我的地址</a></center>
			</div>
			</div>
				
			<div class=second_c_02_b1_2>
			
				<h1 style="font-size: 25px">
					<br /> <b><span id="nicknameV" class="pro"><s:property
								value="#session.user.nickname" /> </span> </b>
					<s:if test="#session.user.user_integral>1">
						<input id="nicknameM" type="button" value="修改" />
					</s:if>
					<s:else>
						<input type="button" value="修改" disabled="disabled" />
						<font color=red size=1px>等级不足</font>
					</s:else>
					<span style="color: red" id="nick_msg"></span> <br /> <br /> <font
						size=2px color=red class="pro"> &nbsp;&nbsp;了解等级特权
						&nbsp;&nbsp; <a href="#" id="lv"> <img id="lvimg"
							src="../images/button_down1.gif" style="display:inline" />
					</a> （<b>Lv. <s:property value="#session.user.user_integral" /> </b>）
					</font>
				</h1>
				<div id="divlv"
					style="display:none;width: 100% px; position: relative;; font-size: 13px;background-color:#FFF;border: 1px solid #000;">
					<div class="pro">
						<img src="../images/book_no0_1.gif" style="display:inline;" />
						&nbsp;&nbsp; 0级：无特权，只有购买及个人信息修改权限；
					</div>
					<div class=line_xx></div>
					<div class="pro">
						<img src="../images/book_no0_2.gif" style="display:inline;" />
						&nbsp;&nbsp; 1级：可以上传下载文件；
					</div>
					<div class=line_xx></div>
					<div class="pro">
						<img src="../images/book_no0_3.gif" style="display:inline;" />
						&nbsp;&nbsp; 2级：可以更改昵称；
					</div>
					<div class=line_xx></div>
					<font color=blue>你可以通过购买书籍进行积分加权来提升等级！</font>

				</div>
				<h3>
					邮箱： <input id="emailM" type="button" value="修改" /> <b><span
						id="emailV" class="pro"><s:property
								value="#session.user.email" /> </span> </b> <span style="color: red"
						id="email_msg"></span> <br /> 密码： <input id="pwdM" type="button"
						value="修改" /> <span class="pro">*********</span> <span
						style="color: red" id="pwd_msg"></span> <br /> 最后一次登陆时间： <span
						class="pro"> <b><s:date
								name="#session.user.last_login_time"
								format="yyyy年MM月dd日hh:ss:mm" /> </b> </span> <br /> 最后一次登陆IP： <span
						class="pro"> <b><s:property
								value="#session.user.last_login_ip" /> </b> </span> <br /> 邮箱验证状态： <span
						class="pro"> <b> <s:if
								test="#session.user.is_email_verify==\"y\"">
							已验证
							</s:if> <s:else>
								<font size=1px color=red>邮箱未验证, 你将不能进行购买等操作！</font>
								<a href="../user/verify_form.jsp"> 去验证</a>
							</s:else> </b> </span>
				</h3>
				<br />

			</div>
		</div>

		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<br /> <br /> <br />
				<s:if test="#session.user.user_integral>0">
					<table width=646px height=100% border=3px id="upfileview">
						<tr>
							<td id="msg"
								style="background-color:#354fc9;color:#FFF;border-left:0px solid #FFF;"
								width=50%><img alt="dang" src="../images/myc.png"
								style="border:0px solid #000;display:inline;">
							<s:property
								value="#session.user.email" />\当当\我的网盘\我的文件夹\</td>
						</tr>

						<tr>
							<td id="tdimg"
								style="padding:5px 10px;border-top: 0px solid #000;">
								<div style="display:block;padding:0px 0px 20px 0px;">当前一次可上传最大字节数：10MB</div>
								<s:iterator value="#session.upfile" status="aa">
									<div
										title="文件名称：<s:property value='filename'/>
后缀名称：<s:property value='filetype'/>
文件类型：<s:property value='contenttype'/>
创建时间：<s:date  name="addtime" format="yyyy年MM月dd日hh:mm:ss"/>"
										style="width:65px;float:left;word-break:break-all;table-layout:fixed;white-space:nowrap;
											padding:10px 10px;height:65px;
												overflow:hidden;border:1px solid #FFF;z-index:0;position:relative; ">
												 <a
											href="javascript:;"
											style="color:#000;z-index: 10000;">


											<center>
												<img class="<s:property value='filetype'/>"
													id="imgid<s:property value='#aa.index'/>"
													src="../images/filetype/<s:property value='filetype'/>.gif"
													width=32px style="border:0px solid #000;z-index: -1;">
											</center> <span><s:property value='filename' /></span> </a>
									</div>
								</s:iterator></td>
						</tr>
					</table>
					
				</s:if>
			</div>
			<div class=second_c_02_b1_2>
				<h1>
					<br />
				</h1>
				<h2 style="width: 566px; color: #666">个人文件上传下载</h2>
				<form action="upload" method="post" enctype="multipart/form-data"
					id="upfilesubmit" style="width:200%">
					<s:if test="#session.user.user_integral>0">
						<input type="file" id="mf" name="mf">
						<input id="upfileM" type="submit" value="上传" />
						<span id="upfilespan" style="color:red;font-size:13px;"></span>
					</s:if>
					<s:else>
						<input type="file" disabled="disabled">
						<input type="button" value="上传" disabled="disabled" />
						<font color=red>等级不足</font>
					</s:else>
					<span style="color: red" id="upfile_msg"></span>
				</form>

			</div>
		</div>





	</div>

</div>
</s:if>