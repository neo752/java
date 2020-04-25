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
    <input type="hidden" value="item" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>订单ID</td>
    	<td>商品ID</td>
    	<td>商品名</td>
    	<td>当当价</td>
    	<td>商品数量</td>
    	<td>合计</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    		<tr style="text-align: center;">
    <td  colspan="7" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="ilist.size()==0">
    	<td><input type="hidden" name="item.id"></td>
    	<td><input type="hidden" name="item.order_id"></td>
    	<td><input type="hidden" name="item.product_id"></td>
    	<td><input type="hidden" name="item.product_name"></td>
    	<td><input type="hidden" name="item.dang_price"></td>
    	<td><input type="hidden" name="item.product_num"></td>
    	<td><input type="hidden" name="item.amount"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="ilist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="item.id">${id}</td>
    	<td><input type="hidden" value="${order_id}" name="item.order_id">${order_id}</td>
    	<td><input type="hidden" value="${product_id}" name="item.product_id">${product_id}</td>
    	<td><input type="hidden" value="${product_name}" name="item.product_name">${product_name}</td>
    	<td><input type="hidden" value="${dang_price}" name="item.dang_price">${dang_price}</td>
    	<td><input type="hidden" value="${product_num}" name="item.product_num">${product_num}</td>
    	<td><input type="hidden" value="${amount}" name="item.amount">${amount}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
