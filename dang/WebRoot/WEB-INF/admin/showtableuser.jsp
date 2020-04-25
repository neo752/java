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
    
    <title>My JSP 'showtableuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.7.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
  </head>
  
   <body>
    <div style="width:100%"  class="divstyle"><input type="hidden" value="${page}" id="pageval">
    <input type="hidden" value="user" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>邮箱</td>
    	<td>昵称</td>
    	<td>密码</td>
    	<td>等级</td>
    	<td>邮箱验证</td>
    	<td>验证码</td>
    	<td>最后登陆时间</td>
    	<td>最后登陆IP</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    		<tr style="text-align: center;">
    <td  colspan="9" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="uplist.size()==0">
    	<td><input type="hidden" name="user.id"></td>
    	<td><input type="hidden" name="user.email"></td>
    	<td><input type="hidden" name="user.nickname"></td>
    	<td><input type="hidden" name="user.password"></td>
    	<td><input type="hidden" name="user.user_integral"></td>
    	<td><input type="hidden" name="user.is_email_verify"></td>
    	<td><input type="hidden" name="user.email_verify_code"></td>
    	<td><input type="hidden" name="user.last_login_time"></td>
    	<td><input type="hidden" name="user.last_login_ip"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="ulist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="user.id">${id}</td>
    	<td><input type="hidden" value="${email}" name="user.email">${email}</td>
    	<td><input type="hidden" value="${nickname}" name="user.nickname">${nickname}</td>
    	<td><input type="hidden" value="${password}" name="user.password">${password}</td>
    	<td><input type="hidden" value="${user_integral}" name="user.user_integral">${user_integral}</td>
    	<td><input type="hidden" value="${is_email_verify}" name="user.is_email_verify">${is_email_verify}</td>
    	<td><input type="hidden" value="${email_verify_code}" name="user.email_verify_code">${email_verify_code}</td>
    	<td><input type="hidden" value="${last_login_time}" name="user.last_login_time">${last_login_time}</td>
    	<td><input type="hidden" value="${last_login_ip}" name="user.last_login_ip">${last_login_ip}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
