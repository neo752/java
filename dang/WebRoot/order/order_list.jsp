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
		<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/myjs.js"></script>
			<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/buy.js"></script>
		<script type="text/javascript">
		$(function(){
		
			$(".td_no_bord").hover(function(){
				$(this).css("background-color","#ABC");
			},function(){
				$(this).css("background-color","#FFF");
				
			});
				$("#heada").load('head_category');
			
				$("body").hide().show(500);

				$(".td_no_bord").click(function(){
					var id=$(this).children("td").eq(0).html();
					getitem(id);
				  	return false;
				});
		});
		
		</script>
	</head>
	<body>
		
			<!-- 头部开始 -->
	<div id="heada"></div>
	<!-- 头部结束 -->
		<br />
		<br />
		<div id="orderdivs" style="display:none;background-color:#FFF"></div>
		<div class="my_shopping">
			<img class="pic_shop" src="../images/icon_present.gif" style="width:80px;height:80px;display:inline" />
			<font size=5px color="#FFF"><b>我的订单</b></font>

		</div>
		<div id="div_choice" class="choice_merch" style="background-color:#FFF"><br/>
			<h2 id="cart_tips">
				你正在查看你的订单信息
			</h2>
			
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal" style="color:#002">
					<tr class="tabl_buy_title">
						<td >
							<span>订单号</span>
						</td>
							<td >
							<span>状态</span>
						</td>
						<td>
							<span >订单时间</span>
						</td>
						<td >
							<span >订单描述</span>
						</td>
						<td >
							<span >总价</span>
						</td>
						<td >
							<span >收货人</span>
						</td>
						<td >
							<span >完整地址</span>
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
					</tr>
					
                      <!--列表开始 -->
 <s:iterator value="orderList">
						<tr class='td_no_bord' >
							<td style="padding: 15px 0px;border-bottom:1px solid #CCE">${id}</td>
							<td style="border-bottom:1px solid #CCE">
							<s:if test="status==0">
								未付款
							</s:if>
							<s:else>
								已付款
							</s:else>
							</td>
							<td style="border-bottom:1px solid #CCE">
							${order_time}
							</td>
							<td style="border-bottom:1px solid #CCE">
							${order_desc}
							</td>
							<td style="border-bottom:1px solid #CCE">
								￥${total_price}
							</td>
							<td style="border-bottom:1px solid #CCE">
							${receive_name}
							</td>
							<td  style="border-bottom:1px solid #CCE">
								<span >${full_address}</span>
							</td>
							<td  style="border-bottom:1px solid #CCE">
								<span >${postal_code}</span>
							</td>
							<td  style="border-bottom:1px solid #CCE">
								<span >${mobile}</span>
							</td>
							<td  style="border-bottom:1px solid #CCE">
								<span >${phone}</span>
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



