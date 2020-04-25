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
				$(".modifycart").children("a:even").click(function(){
					var tdspan=$(this).parent("td").prev().children("span");
					var id=$(this).parent("td").parent("tr").children("td").html();
						modifycart(1,id,tdspan);
					return false;
			});
			$(".modifycart").children("a:odd").click(function(){
					var tdspan=$(this).parent("td").prev().children("span");
					var id=$(this).parent("td").parent("tr").children("td").html();
					modifycart(0,id,tdspan);
					return false;
			});
			
		});
			function modifycart(num,id,tdspan){
						$.post("modifycart",{"qtytype":num,"id":id},function(data){
						if(num==0){
							if(tdspan.html()<=1){
								tdspan.html(1);
							}else{
									tdspan.html(parseInt(tdspan.html())-1);
							} 
						}else{
									tdspan.html(parseInt(tdspan.html())+1);
							}
									$("#total_account").html(data);
									$.post("gettotalAndtakeprice",function(take){
										$("#total_economy").html(take);
									});
						});
			}
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			你可以对列表中的商品：<a href="clearall">清空所有</a>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>ID</span>
						</td>
							<td class="buy_td_6">
							<span>图片</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_1" colspan="2">
							<span>操作
			<a href="clearup">清空购物车</a></span>
						</td>
					</tr>
					<tr class='objhide' >
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->
 <s:iterator value="carts">
 <s:if test="buy==true">
						<tr class='td_no_bord' >
							<td style="padding: 15px 0px;border-bottom:1px solid #CCE">
								${product.id}
							</td>
							<td >
								<span ><img style="width:30px;border:1px solid #000;" src="../productImages/${product.productpic}"/> </span>
							</td>
							<td style="border-bottom:1px solid #CCE">
								<a href="#">${product.productname}</a>
							</td>
							<td class="buy_td_5" style="border-bottom:1px solid #CCE">
								<span class="c_gray">￥${product.fixed_price}</span>
							</td>
							<td class="buy_td_4" style="border-bottom:1px solid #CCE">
								&nbsp;&nbsp;
								￥<span>${product.dang_price}</span>
							</td>
							<td class="buy_td_1" style="border-bottom:1px solid #CCE">
								&nbsp;&nbsp;
								<span>${qty}</span>
							</td>

							<td class="modifycart" >
								<a href="#"><img src="../images/button_down2.gif"/></a>
								<a href="#"><img src="../images/button_down1.gif"/></a>
							</td>
							<td style="border-bottom:1px solid #CCE"> 
								<a href="delcart?id=${product.id}">删除</a>
							</td>
						</tr>
						 
					<!-- 购物列表结束 -->
					</s:if>
					</s:iterator>
				</table>	
	<s:if test="carts.size==0||totalprice==0">
				<div id="div_no_choice" >
									<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品＞＞</a>
					</div>
					<div class="choice_title"></div>
					

					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				
</s:if><s:else>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品＞＞</a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${takeprice}</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${totalprice}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='orderinfo' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
</s:else>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
			<thead style="background-color:#DDD">   
				<tr>
						<td width="58" class="buy_td_5">
					ID
						</td>
						<td width="365" class="buy_td_4">
							商品名称 
						</td>
						<td width="106" class=buy_td_5>
							原价
						</td>
						<td width="134" class=buy_td_4>
							<span>当当价格</span>
						</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>数量</span>
							</td>
						<td width="56" class=buy_td_1 colspan="2" style="text-align: center;">
						操作
			<a href="cleardown">清空恢复区</a> 
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
			</thead>
				<tbody>
				
 <s:iterator value="carts">
 <s:if test="buy==false">
					<tr class='td_no_bord' >
						<td width="58" class=buy_td_6>
						${product.id}
						</td>
						<td width="365" class=t2>
							<a href="#">${product.productname}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${product.fixed_price}
						</td>
						<td width="134" class=buy_td_4>
							￥<span>${product.dang_price}</span>
						</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>${qty}</span>
							</td>
						<td width="56" class=buy_td_1 >
						<a href="undelcart?id=${product.id}">恢复</a>
						</td>
						<td style="width:50px" > 
						<a href="removecart?id=${product.id}">彻底删除</a>
						</td>
					</tr>
</s:if>
</s:iterator>


					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>


				</tbody>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



