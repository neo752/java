<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
		<script type="text/javascript">
		$(function(){
			$(".td_no_bord").hover(function(){
				$(this).css("background-color","#ABC");
			},function(){
				$(this).css("background-color","#FFF");
				
			});
			$("body").hide().show(500);
				$("#heada").load('head_category');
		});
		
		</script>
	</head>
	<body >
		<!-- 头部开始 -->
	<div id="heada"></div>
	<!-- 头部结束 -->
		<br />
		<br />
		<div class="my_shopping" >
			<img class="pic_shop" src="../images/second_rmzz.png" style="width:80px;height:80px;display:inline" />
			<font size=5px color=#FFF>我的地址</font>

		</div>
		<div id="div_choice" class="choice_merch" style="background-color:#FFF"><br/>
			<h2 id="cart_tips">
				你正在查看你的收货地址信息
			</h2>
			
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td >
							<span>序号</span>
						</td>
							<td >
							<span>收货人</span>
						</td>
						<td>
							<span >地址</span>
						</td>
						<td >
							<span >邮编</span>
						</td>
						<td >
							<span >手机号</span>
						</td>
						<td >
							<span >电话号</span>
						</td>
						<td  >
							<span>操作</span>
						</td>
					</tr>
					<tr class='objhide' >
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!--列表开始 -->
 <s:iterator value="relist" status="s">
						<tr class='td_no_bord' >
							<td style="padding: 15px 0px;border-bottom:1px solid #CCE">
								${s.count}
							</td>
							<td style="border-bottom:1px solid #CCE">
								<span> ${receive_name}</span>
							</td>
							<td style="border-bottom:1px solid #CCE"> 
									<span>${full_address}</span>
							</td>
							<td  style="border-bottom:1px solid #CCE">
								<span >${postal_code}</span>
							</td>
							<td  style="border-bottom:1px solid #CCE">
								&nbsp;&nbsp;
								<span>${mobile}</span>
							</td>
							<td  style="border-bottom:1px solid #CCE">
								&nbsp;&nbsp;
								<span>${phone}</span>
							</td>
							<td style="border-bottom:1px solid #CCE"> 
								<a href="deladdress?radd.id=${id}">删除</a>
							</td>
						</tr>
						 
					<!-- 列表结束 -->
					</s:iterator>
				</table>
				

			</div>
		</div>
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



