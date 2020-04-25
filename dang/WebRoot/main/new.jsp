<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
		<script type="text/javascript" src="../js/jquery-1.7.js"></script>
	<script type="text/javascript">
		$(function(){
		$(".second_d_wai").hover(function(){
				$(this).css("background-color","#DDF");
			},function(){
				$(this).css("background-color","#FFF"); 
			});
		});
	</script>
	<div id="buydiv" style="display:none"></div>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
<s:iterator value="pros">
	<!--热销图书A开始-->
	<div class="second_d_wai" >
	<input type="hidden" value="${id}"/>
	<div class="price">
		发行日期：<br/><s:date name="addtime" format="yyyy年MM月dd日"/>
		</div>
		<div class="img">
			<a href="javascript:;" target='_blank' class="buybook" name="${id}"><img
					src="../productImages/${productpic}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="javascript:;" class="buybook" name="${id}">${productname}</a><a href="#" target="_blank"></a>
		</div>
		
		<div class="price">
			定价：￥${fixed_price}
		</div>
		<div class="price">
			当当价：￥${dang_price}
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->

</s:iterator>
</div>
<div class="clear"></div>