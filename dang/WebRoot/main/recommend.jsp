<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<script type="text/javascript" src="../js/jquery-1.7.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>
<script type="text/javascript" src="../js/buy.js"></script>
	<script type="text/javascript">
		$(function(){
		
			$("#buylist a").click(function(){
				gethtml($(this).attr("name"));
				return false;
						
			});
			$(".second_c_02_b1").hover(function(){
				$(this).children("div").css("background-color","#DDF");
			},function(){
				$(this).children("div").css("background-color","#FFF");
			});
		});
	</script>
	<div id="buydiv" style="display:none"></div>
<div id="buylist">
	<s:iterator value="blist">
		<div class=second_c_02_b1 >
			<div class=second_c_02_b1_1 >
				<a href='#' target='_blank' class="buybook" name="${id}"><img src="../productImages/${productpic}" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2 >
				<h3>
					<a href="javascript:;" class="buybook" name="${id}">${productname} </a>
				</h3>
				<h4>
					作者：${author}著
					<br />
					出版社：${publishing}&nbsp;&nbsp;&nbsp;&nbsp;出版时间：${publish_time}
				</h4>
				<h5>
					简介:
				</h5><div>${catalogue} </div>
				<h6>
					定价：￥${fixed_price}&nbsp;&nbsp;当当价：￥${dang_price}
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</s:iterator>
</div>
