<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="../css/jqzoom.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="../js/jquery-1.7.js">
</script>
<script type="text/javascript" src="../js/jquery.jqzoom.js">
</script>
<script type="text/javascript">
  $(document).ready(function(){
		    $(".jqzoom").jqueryzoom({
		        xzoom:180,  // 放大图的宽
		        yzoom:180,  // 放大图的高
		        offset:-300,   // 放大图距离原图的位置
		        position:'right'  // 放大图在原图的右边(默认为right)
		    });
	    });
	//购物车
	$(function() {
		$('.imagename')
				.mouseover(
						function(e) {
							var nnn = (parseInt($("#autoprependdiv1").css(
									"left")) - 52);
							var div = $("<div id='tips'><img src='"
									+ $(this).attr("src") + "' width='" + nnn
									+ "px' /></div>");
							$('#list_r_line').append(div).css("display",
									"inline");
							$('#tips').css('top', e.pageY + 10 + 'px').css(
									'left', e.pageX + 10 + 'px');
						}).mouseout(function(e) {
					$('#tips').remove();
					$('#list_r_line').css("display", "none");
				}).mousemove(
						function(e) {
							$('#tips').css('top', e.pageY + 10 + 'px').css(
									'left', e.pageX + 10 + 'px');
						});
		$(".buy").click(function() {
			buybutton = $(this);
			var buybuttonhtml = $(this).html();
			var buynext = $(this).next();
			var id = $(this).attr("id");
			$.post("addcart", {
				"id" : id
			}, function(data) {
				if (data) {
					$("#cartnum").load("cartnum");
					buynext.html("<font color=blue>购买成功！</font>").hide().show(10, function() {
						//myshowdiv();
							buybutton.show(2000, function() {
								buybutton.next().html("");
							});
						});
					buybutton.hide();
				} else {
					buynext.html("<font color=red>商品已在购物车内！</font>").hide().show(10, function() {
						//myshowdiv(); 
							buybutton.hide().show(2000, function() {
								buybutton.next().html("");
							});
						});
					buybutton.hide();
				}
			}, "json");
			return false;
		});
		$("#mydang").hover(function() {
			$("#cartaddress").slideDown(200);
		}, function() {
			$("#cartaddress").slideUp(200);
		});
		$(".bbbbb").hover(function() {
			$(this).css("background-color", "#FFF");
		}, function() {
			$(this).css("background-color", "#ACB");
		});

	});
</script>
<div id="list_r_line"
	style="position: fixed; top: 0px; left: 0px; border: 6px dotted #CDE; padding: 20px 20px; display: none"></div>
<table style="background-color: #FFF;">
	<tr>
		<td>
		<div>
		<div class="jqzoom">
                <img style="height:200px" src="../productImages/${book.productpic}" alt="房间演示" jqimg="../productImages/big/${book.productpic}" />
            </div>
			</div>
		</td>
		<td style="padding: 15px 15px">

			商品名称：
			<br />
			<font size=4px color="#006" style="padding: 0px 0px 0px 15px">
				${book.productname}</font>
			<br />
			商品简介：
			<div style="border: 1px solid #BCD;">
				${book.description}
			</div>
			<br />
			关键字：${book.keywords}
			<br />
			上架时间：${book.addtime}
			<br />
			原价：
			<span style="text-decoration: line-through; font-size: 15px">
				${book.fixed_price}</span>&nbsp;&nbsp;&nbsp;&nbsp; 当当价格：
			<font color=red size=5px>${book.dang_price}</font>
			<br />
			<a href="#" class="buy" id="${book.id}"> <img
					src='../images/buttom_goumai.gif' /> </a>
			<span id="cartinfo"></span>
			<br />

		</td>
	</tr>
	<tr>
		<td colspan="2"
			style="font-size: 20px; color: #000; background-color: #ABE; text-align: center;">
			书籍信息
		</td>
	</tr>
	<tr>
		<td>
			作者：${book.author}
		</td>
		<td>
			出版社：${book.publishing}
		</td>
	</tr>
	<tr>
		<td>
			出版时间：${book.publish_time}
		</td>
		<td>
			印刷时间：${book.print_time}
		</td>
	</tr>
	<tr>
		<td>
			字数：${book.word_number}字
		</td>
		<td>
			页数：${book.total_page}页
		</td>
	</tr>
	<tr>
		<td>
			版次：${book.which_edtion}次
		</td>
		<td>
			打印次数：${book.print_number}次
		</td>
	</tr>
	<tr>
		<td colspan="2">
			出版批号：${book.isbn}
		</td>
	</tr>
	<tr>
		<td colspan="2">
			作者简介：${book.author_summary}
		</td>
	</tr>
	<tr>
		<td colspan="2">
			书籍简介：${book.catalogue}
		</td>
	</tr>
</table>


