<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminmain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<STYLE type="text/css">
	*{
	border-radius:5px;
	-moz-border-radius:5px;
	-khtml-border-radius:5px;
	-webkit-border-radius:5px;
	}
	</STYLE>
<script type="text/javascript" src="js/jquery-1.7.js"></script>
<script type="text/javascript" >

var clickmenu=0;
$(function(){
	$("#centent thead tr td a").click(function(){
		$("#tabletype1").val($(this).attr("id"));
		var pathurl="showtable"+$(this).attr("id")+"?tabletype="+$("#tabletype1").val();
		clickmenu=$(this).attr("class");
		$("#centent thead tr td").css("background-Color","#446").children("a").css("color","#FFF");
		$(this).parent().css("background-Color","#CCA").css("border-bottom","1px solid #FFF").css("color","#FFF");
		$(this).css("color","#000");
		$("#showdivs").load(pathurl);
	});
	
	$("#centent thead tr td").hover(function(){
		if($(this).children("a").attr("class")!=clickmenu){
		$(this).css("background-Color","#CCA").css("border-bottom","0px solid #FFF").children("a").css("color","#000");
		}
	},function(){
		if($(this).children("a").attr("class")!=clickmenu){
		$(this).css("background-Color","#446").css("border-bottom","1px solid #FFF").children("a").css("color","#FFF");
		}
	});
	for(var i=0;i<9;i++){
		if($("#centent thead tr td a").eq(i).attr("id")==$("#tabletype1").val()){
			$("#centent thead tr td a").eq(i).click();
		}
	}
	
	
	$("#nextpage").click(function(){
		var p=parseInt($("#pageval").val())+1;
		page(p);
	});
	$("#previouspage").click(function(){
		var p=parseInt($("#pageval").val())-1;
		page(p);
	});
	$("#pagenum").keyup(function(e){
		if($(this).val().trim()==""||$(this).val().trim()==null){
			$("#redirectbutton").attr("disabled","disabled");
		}else{
			$("#redirectbutton").removeAttr("disabled");
			if(e.which == 13){
				$("#redirectbutton").click();
			}
		}
	});
	$("#redirectbutton").click(function(){
		page($("#pagenum").val());
	});
});
	function page(p){
		$("#showdivs1").load("showtable"+$("#tabletype").val()+"?page="+p+"&tabletype="+$("#tabletype").val(),function(){
			$("#showdivs1").children(".divstyle").hide().slideDown(300,function(){
				$("#showdivs1").html("");
			});
			$("#showdivs").children(".divstyle").slideUp(300,function(){
				$("#showdivs").load("showtable"+$("#tabletype").val()+"?page="+p+"&tabletype="+$("#tabletype").val());
			});
		});
	}
</script>
<style type="text/css">
	#centent thead tr td{
		padding:  3px 10px;
		border:1px solid #FFF;
	}
	#centent thead tr td a{
		text-decoration:none;
		color:#FFF;
		font-weight:bold;
	}
</style>
  </head>
  
  <body>
   
	<center><div style="width:80%;height:50px;border:8px solid #456;background-Color:#459;color:#FFF;padding: 0px 30px 15px 30px;font-size:25px;border-bottom: 0px solid #FFF;">
	<b>当当后台管理系统</b><br/>
	<font size=2px>
	登陆管理员ID:${session.user.id}&nbsp;&nbsp;&nbsp;
	昵称：${session.user.nickname}&nbsp;&nbsp;&nbsp;
	邮箱：${session.user.email}&nbsp;&nbsp;&nbsp;
	等级：<font  size=5px>${session.user.user_integral}</font>级&nbsp;&nbsp;&nbsp; </font>
	<input type="button" value="退出到登陆" onclick="location='removeUser1'">
	</div>
	<div style="border:8px solid #456;border-top: 0px solid #FFF;background-Color:#CCF;width:80%;;padding: 15px 30px;text-align: left;">
	<center>
	<div id="table_msg">表中字段名后数字为权限等级</div>
	<table style="background-color:#446;padding:  5px 10px" id="centent">
	<thead><tr>
	<s:if test="#session.user.user_integral>=105">
	<td><a class="1" href="javascript:;" id="user">用户(105)</a></td>
	</s:if><s:if test="#session.user.user_integral>=100">
	<td><a class="2" href="javascript:;" id="book">书籍(100)</a></td>
	</s:if><s:if test="#session.user.user_integral>=103">
	<td><a class="3" href="javascript:;" id="category">类别(103)</a></td>
	</s:if><s:if test="#session.user.user_integral>=103">
	<td><a class="4" href="javascript:;" id="categoryproduct">类别商品关联(103)</a></td>
	</s:if><s:if test="#session.user.user_integral>=102">
	<td><a class="5" href="javascript:;" id="item">已购商品(102)</a></td>
	</s:if><s:if test="#session.user.user_integral>=105">
	<td><a class="6" href="javascript:;" id="order">订单(105)</a></td>
	</s:if><s:if test="#session.user.user_integral>=102">
	<td><a class="7" href="javascript:;" id="product">商品(102)</a></td>
	</s:if><s:if test="#session.user.user_integral>=101">
	<td><a class="8" href="javascript:;" id="receiveaddress">地址(101)</a></td>
	</s:if><s:if test="#session.user.user_integral>=100">
	<td><a class="9" href="javascript:;" id="upfile">用户文件(100)</a></td>
	</s:if>
	
	</tr>
	</thead>
	<tbody style="background-Color:#CCA;">
	<tr><td style="background-Color:#446;" colspan="3 ">
	<input type="button" value="上一页" id="previouspage">
	<input type="button" value="下一页" id="nextpage">
	<input size=7 placeholder="输入页数" id="pagenum" onkeyup="this.value=this.value.replace(/\D/g,'')" >
	<input type=button value="跳转" id="redirectbutton" disabled="disabled">
	<input type="hidden" id="tabletype1" value="${tabletype}">
	</td>
	<td style="background-Color:#446;"></td>
	<td style="background-Color:#446;"></td>
	<td style="background-Color:#446;"></td>
	<td style="background-Color:#446;"></td>
	<td style="background-Color:#446;"></td>
	</tr>
	<tr><td colspan="9" id="showdivs">
	</td></tr>
	<tr><td colspan="9" id="showdivs1"></td></tr>
	</tbody>
	</table></center>
	</div>
	</center>
  </body>
</html>
