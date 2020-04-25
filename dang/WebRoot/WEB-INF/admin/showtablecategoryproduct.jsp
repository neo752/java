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
    <input type="hidden" value="categoryproduct" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>商品ID</td>
    	<td>类别ID</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    		<tr style="text-align: center;">
    <td  colspan="3" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="cplist.size()==0">
    	<td><input type="hidden" name="categoryproduct.id"></td>
    	<td><input type="hidden" name="categoryproduct.prioduct_id"></td>
    	<td><input type="hidden" name="categoryproduct.cat_id"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="cplist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="categoryproduct.id">${id}</td>
    	<td><input type="hidden" value="${prioduct_id}" name="categoryproduct.prioduct_id">${prioduct_id}</td>
    	<td><input type="hidden" value="${cat_id}" name="categoryproduct.cat_id">${cat_id}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
