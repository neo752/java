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
    <input type="hidden" value="product" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>商品名</td>
    	<td>描述</td>
    	<td>添加时间</td>
    	<td>原价</td>
    	<td>当当价</td>
    	<td>关键字</td>
    	<td>删除状态</td>
    	<td>商品图片</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    	<tr style="text-align: center;">
    <td  colspan="9" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="plist.size()==0">
    	<td><input type="hidden" name="product.id"></td>
    	<td><input type="hidden" name="product.productname"></td>
    	<td><input type="hidden" name="product.description"></td>
    	<td><input type="hidden" name="product.addtime"></td>
    	<td><input type="hidden" name="product.fixed_price"></td>
    	<td><input type="hidden" name="product.dang_price"></td>
    	<td><input type="hidden" name="product.keywords"></td>
    	<td><input type="hidden" name="product.has_deleted"></td>
    	<td><input type="hidden" name="product.productpic"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="plist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="product.id">${id}</td>
    	<td><input type="hidden" value="${productname}" name="product.productname">${productname}</td>
    	<td><input type="hidden" value="${description}" name="product.description">${description}</td>
    	<td><input type="hidden" value="${addtime}" name="product.addtime">${addtime}</td>
    	<td><input type="hidden" value="${fixed_price}" name="product.fixed_price">${fixed_price}</td>
    	<td><input type="hidden" value="${dang_price}" name="product.dang_price">${dang_price}</td>
    	<td><input type="hidden" value="${keywords}" name="product.keywords">${keywords}</td>
    	<td><input type="hidden" value="${has_deleted}" name="product.has_deleted">${has_deleted}</td>
    	<td><input type="hidden" value="${productpic}" name="product.productpic">${productpic}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
