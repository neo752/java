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
		$(function(){
					$("#heada").load('head_category',function(){
		
		$(this).hide().show(2000);
		});
					$("#left").load('../main/all_category',function(){
		
		$(this).hide().show(2000);
		});
					$("#recommend").load('user_info.jsp',function(){
		
		$(this).hide().show(2000);
		});
				});
			
			</script>
	</head>
	<body id=body1>
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
			<div id="left" class="book_left">
			</div>
			<script type="text/javascript">$("#left").load('../main/all_category.jsp');</script>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center" >

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend" style="width:700px">
				</div>
			

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



		
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
