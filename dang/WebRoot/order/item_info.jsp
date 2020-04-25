<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<style type="">
.fill_message .tab_login{ width:758px; border-collapse:collapse;}
.fill_message .tab_login td{ padding:15px 5px 13px 5px; border:solid 1px #dadada}
.fill_message .tab_login .w1{ width:160px; padding-right:0; text-align:right; font-size:14px; background-color:#e8fbff}
.fill_message .tab_login .change_c{ background-color:#ffece8}

.fill_message .tab_login .text_input{ width:170px; height:17px; padding:3px 2px 0 1px; border:solid 1px #a8a6ab; margin-left:20px; float:left}/*07.8.7modify*/
.fill_message .tab_login .yzm_img{ width:100px; height:30px; float:left; margin-left:20px}
.fill_message .tab_login .yzm_input{ width:54px; height:17px; padding:3px 2px 0 1px; border:solid 1px #a8a6ab; margin-left:15px; float:left}/*07.8.7modify*/
.fill_message .tab_login .text_left{ float:left; padding-left:20px;word-break:break-all;}
.fill_message .tab_login .change_red{ color:#ff0000}
.fill_message .tab_login .text_left p{ padding-top:3px;word-break:break-all;}
		</style>
	</head>
	<body>
		<div class="fill_message">
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品ID</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>当当单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>

				<!-- 订单开始 -->
				<s:iterator value="itemList" status="s">
					<tr>
						<td valign="top">
						${product_id}
						</td>
						<td valign="top">
							${product_name}
						</td>
						<td valign="top">
						${dang_price}
						</td>
						<td valign="top">
							${product_num}
						</td>
						<td valign="top">
						${amount}
						</td>
					</tr>
				</s:iterator>
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥${totalprice}</b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			

		</div>
	</body>
</html>

