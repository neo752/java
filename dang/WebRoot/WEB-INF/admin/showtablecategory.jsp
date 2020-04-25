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
    <input type="hidden" value="category" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>本类别ID</td>
    	<td>类别英文名</td>
    	<td>类别名</td>
    	<td>描述</td>
    	<td>父ID</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    	<tr style="text-align: center;">
    <td  colspan="6" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="clist.size()==0">
    	<td><input type="hidden" name="category.id"></td>
    	<td><input type="hidden" name="category.turn"></td>
    	<td><input type="hidden" name="category.en_name"></td>
    	<td><input type="hidden" name="category.name"></td>
    	<td><input type="hidden" name="category.description"></td>
    	<td><input type="hidden" name="category.parent_id"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="clist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="category.id">${id}</td>
    	<td><input type="hidden" value="${turn}" name="category.turn">${turn}</td>
    	<td><input type="hidden" value="${en_name}" name="category.en_name">${en_name}</td>
    	<td><input type="hidden" value="${name}" name="category.name">${name}</td>
    	<td><input type="hidden" value="${description}" name="category.description">${description}</td>
    	<td><input type="hidden" value="${parent_id}" name="category.parent_id">${parent_id}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
