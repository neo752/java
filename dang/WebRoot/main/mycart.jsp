<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../common/taglib.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
$(function(){
	$("#mycart").hover(function(){
			$("#cartlist").slideDown(200);
		},function(){
		$("#cartlist").slideUp(200);
		});
		$(".aaaaa").hover(function(){
			$(this).css("background-color","#FFF");
		},function(){
				$(this).css("background-color","#ACB");
		});
		if($("#cartsize").html()==0){
			$("#cartsize").css("text-decoration","none");
		}else{
			$("#cartsize").css("text-decoration","blink");			
		}
		$("#cartlist a").click(function(){
				gethtml($(this).attr("name"));
				return false;
						
			});
});
		</script>
		<div id="buydiv" style="display:none"></div>
		<div id="mycart">
<a href="findallcart" id="cart">购物车(<font color=#F66 size=3px>
<b id="cartsize" style="text-decoration:blink">${cartsize} </b>
</font>)</a>

<div id="cartlist" style="position: absolute; z-index:9;display:none;">
	<s:iterator value="carts" status="s" >
 <s:if test="buy==true">
	 <a href="javascript:;"  class="buybook" name="${product.id}">
	<div class="aaaaa" style="background-color:#ACB;">
<span><img src="../productImages/${product.productpic}" width="10px"/></span>
	<div style="width:10%;white-space:nowrap;display:inline;
		text-overflow:ellipsis;
		-o-text-overflow:ellipsis;
		overflow:hidden;">${product.productname}</div>&nbsp;&nbsp;
	<span style="color:red">${qty}</span>个

	</div>	</a>
	</s:if>
</s:iterator> 
</div>

</div>