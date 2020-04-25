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
  
  <body >
    <div style="width:100%" class="divstyle"><input type="hidden" value="${page}" id="pageval">
    <input type="hidden" value="receiveaddress" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>用户ID</td>
    	<td>收货人</td>
    	<td>完整地址</td>
    	<td>邮编</td>
    	<td>手机号</td>
    	<td>电话号</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    		<tr style="text-align: center;">
    <td  colspan="7" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="rlist.size()==0">
    	<td><input type="hidden" name="receiveaddress.id"></td>
    	<td><input type="hidden" name="receiveaddress.user_id"></td>
    	<td><input type="hidden" name="receiveaddress.receive_name"></td>
    	<td><input type="hidden" name="receiveaddress.full_address"></td>
    	<td><input type="hidden" name="receiveaddress.postal_code"></td>
    	<td><input type="hidden" name="receiveaddress.mobile"></td>
    	<td><input type="hidden" name="receiveaddress.phone"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="rlist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="receiveaddress.id">${id}</td>
    	<td><input type="hidden" value="${user_id}" name="receiveaddress.user_id">${user_id}</td>
    	<td><input type="hidden" value="${receive_name}" name="receiveaddress.receive_name">${receive_name}</td>
    	<td><input type="hidden" value="${full_address}" name="receiveaddress.full_address">${full_address}</td>
    	<td><input type="hidden" value="${postal_code}" name="receiveaddress.postal_code">${postal_code}</td>
    	<td><input type="hidden" value="${mobile}" name="receiveaddress.mobile">${mobile}</td>
    	<td><input type="hidden" value="${phone}" name="receiveaddress.phone">${phone}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
