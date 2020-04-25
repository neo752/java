<%@page contentType="text/html;charset=utf-8"%>

<%@include file="../common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<%@include file="../common/common.jsp"%>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
		<script type="text/javascript">
		var retime;
	$(function() {
		$("#heada").load('head_category');
		$('#new').load('new');
		$('#hot').load('hot');
		$('#newhotlist').load('newhotaction');
		$("#recommend").load('recommend');
		retime=setInterval(recommend,5000);
		$("#left").load('all_category');
		$("#left").hide().show(2000);
	});
	function recommend(){
		$("#recommend").fadeOut(1000 ,function(){$("#recommend").load('recommend')})
			.fadeIn(  1000 );
	}
</script>
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<div id="heada"></div>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg"
					border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left"></div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 >
					<h2>
						编辑推荐
					</h2>
					<div id=__bianjituijian/danpin>
						<div class=second_c_02 id="recommend">
						</div>
					</div>
				</div>
				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot"></div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->

				<div class="book_c_border2" id="new"></div>
				<!--最新上架图书结束-->

			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">

				<form action="search" method="post">
					<div style="padding: 10px 20px; border: 1px solid #9bb17e;">
						<script type="text/javascript">
	$(function() {
		var i = $("#inputtext");
		var n1 = $("#numinputdiv1");
		var n = $("#numinputdiv");
		i.keyup(function() {
			if (i.val() == "") {
				divch(n1, 0, n, "");
			} else {
				divch(n1, 1, n, i.val());
			}
		});
		i.blur(function() {
			divch(n1, 0, n, "");
		});
		i.focus(function() {
			if (i.val() == "") {
				divch(n1, 0, n, "");
			} else {
				divch(n1, 1, n, i.val());
			}
		});

	});
	function divch(obj1, opa, obj2, val) {
		obj1.css("opacity", opa);
		obj2.html(val);
	}
</script>
						<input id="inputtext" placeholder="输入你要搜索的关键字" name="searchval" />
						<input type="submit" value="&nbsp;&nbsp;搜索"
							style="background: url('../images/default08temp/search1.gif') top left repeat-y" />
						<div id="numinputdiv1"
							style="opacity: 0; background-color: #AAA; padding: 0px 0px 2px 0px; position: absolute; width: 150px">
							<div
								style="padding: 5px 5px; border: 1px solid #9bb17e; background-color: #EEE; height: 100%; color: blue; font-size: 18px"
								id="numinputdiv"></div>
						</div>

					</div>
				</form>
				<!--热卖新书开始-->
				<div class="book_r_border2" id="__XinShuReMai">
					<script type="text/javascript">
	$(function() {
		$("#hotmenu div").hover(function() {
			$(this).css("background", "#fef5dd");
			$(this).siblings().css("background", "#CCC");
			if ($(this).attr("class") == "new1") {
				$("#hivalue").val(1);
			} else if ($(this).attr("class") == "new2") {
				$("#hivalue").val(2);
			} else if ($(this).attr("class") == "new3") {
				$("#hivalue").val($("#selectyear").val());
			}
			newhotaction();
		}, function() {
		});
		$("#selectyear").change(function() {
			$("#hivalue").val($(this).val());
			newhotaction();
		});
		function newhotaction() {
			$("#newhotlist").load(
					"newhotaction?datewhere=" + $('#hivalue').val());
		}
	});
</script>
					<input type="hidden" id="hivalue" value="1" />

					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<div id="NewProduct_1_o_t">
							<div id="hotmenu" style="background: #CCC">
								<div style="display: inline;" class="new1">
									&nbsp;本周&nbsp;
								</div>
								<div style="display: inline;" class="new2">
									&nbsp;本月&nbsp;
								</div>
								<div style="display: inline;" class="new3">
									&nbsp;按年：
									<select id="selectyear">
										<c:forEach var="i" begin="2010" end="2034" step="1">
											<option value=${i}>
												${i}
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<h3 class="second">
								<span class="dot_r" id="newhotlist"> </span>
								<br />

								<a href="#" target="_blank">更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
				<!--热卖新书结束-->
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
