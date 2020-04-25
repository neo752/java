<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
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
    <div style="width:100%"  class="divstyle"><input type="hidden" value="${page}" id="pageval">
    <input type="hidden" value="book" id="tabletype">
    	<table><thead class="theadstyle"><tr>
    	<td>id</td>
    	<td>出版时间</td>
    	<td>作者</td>
    	<td>出版社</td>
    	<td>字数</td>
    	<td>版本</td>
    	<td>页数</td>
    	<td>印时</td>
    	<td>印号</td>
    	<td>国标号</td>
    	<td>作者简介</td>
    	<td>书简介</td>
    	<td><b>总数:${totalrows}</b></td>
    	</tr></thead><tbody class="tbodystyle">
    	<tr style="text-align: center;">
    	<td  colspan="12" style="border:1px solid #000;">第【${page}/${totalpage}】页</td><td style="border:1px solid #000;"><input type="button" value="增加" id="AdminAdd"></td>
    	</tr>
    	<s:if test="blist.size()==0">
    	<td><input type="hidden" name="book.id"></td>
    	<td><input type="hidden" name="book.publish_time"></td>
    	<td><input type="hidden" name="book.author"></td>
    	<td><input type="hidden" name="book.publishing"></td>
    	<td><input type="hidden" name="book.word_number"></td>
    	<td><input type="hidden" name="book.which_edtion"></td>
    	<td><input type="hidden" name="book.total_page"></td>
    	<td><input type="hidden" name="book.print_time"></td>
    	<td><input type="hidden" name="book.print_number"></td>
    	<td><input type="hidden" name="book.isbn"></td>
    	<td><input type="hidden" name="book.author_summary"></td>
    	<td><input type="hidden" name="book.catalogue"></td>
    	<td></td>
    	</s:if>
    	<s:iterator  value="blist" status="s"><tr>
    	<td><input type="hidden" value="${id}" name="book.id">${id}</td>
    	<td><input type="hidden" value="${publish_time}" name="book.publish_time">${publish_time}</td>
    	<td><input type="hidden" value="${author}" name="book.author">${author}</td>
    	<td><input type="hidden" value="${publishing}" name="book.publishing">${publishing}</td>
    	<td><input type="hidden" value="${word_number}" name="book.word_number">${word_number}</td>
    	<td><input type="hidden" value="${which_edtion}" name="book.which_edtion">${which_edtion}</td>
    	<td><input type="hidden" value="${total_page}" name="book.total_page">${total_page}</td>
    	<td><input type="hidden" value="${print_time}" name="book.print_time">${print_time}</td>
    	<td><input type="hidden" value="${print_number}" name="book.print_number">${print_number}</td>
    	<td><input type="hidden" value="${isbn}" name="book.isbn">${isbn}</td>
    	<td><input type="hidden" value="${author_summary}" name="book.author_summary">${author_summary}</td>
    	<td><input type="hidden" value="${catalogue}" name="book.catalogue">${catalogue}</td>
    	<td style="width:108px"><input type="button" value="修改" class="AdminModify" >
    	<input type="button" value="删除" class="AdminDel" ></td>
    	</tr>
    	</s:iterator>
    	
    	</tbody></table>
    </div>
  </body>
</html>
