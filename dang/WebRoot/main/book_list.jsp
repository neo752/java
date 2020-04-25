<%@page contentType="text/html;charset=utf-8"%>

<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>


		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/jquery-1.7.js">
</script>
		<script type="text/javascript" 
	src="${pageContext.request.contextPath}/js/myjs.js"></script>	
		<script type="text/javascript" src="../js/buy.js">
</script>
		<script type="text/javascript">
	$(function() {
		$("#pagediv").fadeOut(3000);
		  	$("#buylist a:[class!=buy]").click(function(){
				gethtml($(this).attr("name"));
				return false;
						
			});
		//$("body").hide().show(1000);
	});
	function chang() {
		var where = $("#select_order").val();
		var cid = $("#cid").val();
		var pid = $("#pid").val();
		var page = $("#page").val();
		location = "booklist?pid=" + pid + "&cid=" + cid + "&page=1&where="+where;

	}
	$(function() {
		$("#heada").load('head_category');
	});;
</script>
	</head>
	<body>
		&nbsp;
			<div id="buydiv" style="display:none"></div>

	<!-- 头部开始 -->
	<div id="heada"></div>
	<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg"
					border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='../main/main.jsp'>当当图书</a> &gt;分类浏览&gt;
			<font style='color: #cc3300'><span id="bookname"></span> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2 style="height: 600px">
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<s:if test="cid<9">
										<div class=second_fenlei3>
											全部&nbsp;(${totalNum} ) 
										</div>
									</s:if>
									<s:else>
										<div class=second_fenlei>
											<a href='booklist?pid=${pid}&cid=${pid}&where=${where}' id="booka"> 全部&nbsp;(${totalNum} )</a>
											
										</div>
									</s:else>
								</div>
							</li>

							<s:iterator value="cats">

								<div class="clear"></div>
								<!--2级分类开始-->
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<s:if test="id==cid">
											<div class=second_fenlei3>
												${name}&nbsp;( ${pnum})
											</div>
										</s:if>
										<s:else>
											<div class=second_fenlei>
												<a href='booklist?pid=${pid}&cid=${id}&where=${where}' id="booka">${name}&nbsp;(
													${pnum})</a>
											</div>
										</s:else>

									</div>
								</li>
								<!--2级分类结束-->
							</s:iterator>
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<input type="hidden" id="cid" value="${cid}" />
						<input type="hidden" id="pid" value="${pid}" />
						<input type="hidden" id="page" value="${page}" />
						<select onchange="chang()" name='select_order' size='1'
							id="select_order" class='list_r_title_ml'>
							<!-- 第1个 -->
							<s:if test="where==1">
								<option value="1" selected="selected">
									按上架时间 升序
								</option>
							</s:if>
							<s:else>
								<option value="1">
									按上架时间 升序
								</option>
							</s:else>
							<!-- 第2个 -->
							<s:if test="where==2">
								<option value="2" selected="selected">
									按上架时间 降序
								</option>
							</s:if>
							<s:else>
								<option value="2">
									按上架时间 降序
								</option>
							</s:else>
							<!-- 第3个 -->
							<s:if test="where==3">
								<option value="3" selected="selected">
									按当当价格 升序
								</option>
							</s:if>
							<s:else>
								<option value="3">
									按当当价格 升序
								</option>
							</s:else>
							<!-- 第4个 -->
							<s:if test="where==4">
								<option value="4" selected="selected">
									按当当价格 降序
								</option>
							</s:if>
							<s:else>
								<option value="4">
									按当当价格 降序
								</option>
							</s:else>
						</select>

						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->



							<div>


								<s:if test="page<=1">
									<img src='../images/page_up_gray.gif' style="display: inline;" />
								</s:if>
								<s:else>
									<a
										href="booklist?pid=${pid}&cid=<s:property value='cid'/>&page=${page-1}&where=${where}">
										<img src='../images/page_up.gif' style="display: inline;" />
									</a>
								</s:else>
								［共
								<s:property value="totolPages" />
								页］

								<s:if test="page>=totolPages">
									<img src='../images/page_down_gray.gif'
										style="display: inline;" />
								</s:if>
								<s:else>
									<a
										href="booklist?pid=${pid}&cid=<s:property value='cid'/>&page=${page+1}&where=${where}">
										<img src='../images/page_down.gif' style="display: inline;" />
									</a>
								</s:else>


								<a
									href="booklist?pid=${pid}&cid=<s:property value='cid'/>&page=1&where=${where}"><b><font
										size=2px color=blue>首页</font> </b> </a>
								<div style="position: relative; display: inline;">
									<c:forEach var="p" items="${pages}" varStatus="i">
										<c:choose>
											<c:when test="${page==p}">

												<b><font size=4px>${p}</font> </b>
												<div id="pagediv"
													style="text-align:center;border: 1px solid #663;background-color:#FF0;position:absolute;display:inline;top:15px;width:45px">
													<b>第${p}页</b>
												</div>
											</c:when>
											<c:otherwise>
												<a
													href="booklist?pid=${pid}&cid=<s:property value='cid'/>&page=${p}&where=${where}"><font
													color=blue>${p}</font> </a>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${i.index==7}">
												<c:choose>
													<c:when test="${page<(totolPages-7)}">
										 ......
									</c:when>
												</c:choose>
											</c:when>
										</c:choose>
									</c:forEach>
								</div>
								<a
									href="booklist?pid=${pid}&cid=<s:property value='cid'/>&page=${totolPages}&where=${where}"><b><font
										size=2px color=blue>尾页</font> </b> </a>


							</div>



							<!--分页导航结束-->
						</div>
					</div>
					<div id="buylist">
					<s:if test="books.size()==0">
						<div style="width: 700px; height: 500px;">
							<div class="list_r_line"></div>
							<div class="clear"></div>
							<div class="list_r_list">
								没有符合条件的商品！
							</div>
							<div class="clear"></div>
							<div id="divBottomPageNavi" class="fanye_bottom">
							</div>
						</div>

					</s:if>
					<s:else>
						<s:iterator value="books" status="s">

							<!--商品条目开始-->
							<div class="list_r_line"></div>
							<div class="clear"></div>
							<div class="list_r_list">
									
								<span class="list_r_list_book">
								<b class="count"><s:property value="(page-1)*pagesize+#s.count"/></b>、
								<a class="buybook" name="${id}"
									href='#'> ID:${id}<img src="../productImages/${productpic}" /> </a> </span>
								
								<h2 style="display: inline">
									<a  href='#' class="buybook" name="${id}">${productname}</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#'  class="buybook" name="${id}">${author}</a>
								</h4>
								<h4>
									出版社：
									<a href='#'  class="buybook" name="${id}">${publishing}</a>
								</h4>
								<h4>
									出版时间：${publish_time}
								</h4>
								<h5>
									简介：${catalogue}
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${fixed_price}</span>
									<span class="red">￥${dang_price}</span> 节省：￥
									<font color="red" size=3px>${fixed_price-dang_price}</font>
								</h6>
								 <a href="" class="buy" id="${id}"> <img
											src='../images/buttom_goumai.gif' /> </a> <span id="cartinfo"></span>
							</div>

							<!--商品条目结束-->
							<div class="clear"></div>
							<div id="divBottomPageNavi" class="fanye_bottom">
							</div>


						</s:iterator>
					</s:else>
					</div>
				</div>
				<!--图书列表结束-->


			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
