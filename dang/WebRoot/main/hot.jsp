<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
		<script type="text/javascript" src="../js/jquery-1.7.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$(".book_c_04 a").click(function(){
				gethtml($(this).attr("name"));
				return false;
						
			});
		});
	</script>
	<div id="buydiv" style="display:none"></div>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

		<div id="showdiv" style="display:none;">
		</div>
		<div id="div0" style="display:none;">
		
		</div>
		
	<s:iterator value="plist" status="c">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img" style="text-align: center;">
		<font size=1px>TOP</font><font size=4px>${c.count}</font>
			<a href="javascript:;" target='_blank' class="buybook" name="${id}"><img
					src="../productImages/${productpic}" border=0 /> </a>
		</div>
		<div class="shuming" style="text-align: center;">
			<a href="javascript:;" class="buybook" name="${id}" >${productname}</a>
			
		</div>
		<div class="price" style="text-align: center;">销量:<font color=red>${countnum}</font>本</div> 
		<div class="price" style="text-align: center;">
			定价：￥${fixed_price}
		</div>
		<div class="price" >
			当当价：￥${dang_price}
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</s:iterator>

</div>
<div class="clear"></div>