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
<script type="text/javascript">
	$(function() {
		$("#heada").load('head_category');
	});
</script>
</head>
<body>
	&nbsp;


	<!-- 头部开始 -->
	<div id="heada"></div>
	<!-- 头部结束 -->

	<div style="width: 962px; margin: auto;">
		<a href="#"><img src="../images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>
	<div class='your_position'>
		您现在的位置:&nbsp; <a href='../main/main.jsp'>当当图书</a>
		&gt;搜索：${searchval}&gt; <font style='color: #cc3300'><span
			id="bookname"></span> </font>
	</div>

	<div class="book">


		<!--中栏开始-->
		<div class="book_center" style="width:100%;">

			<!--图书列表开始-->
			<div id="divRight" class="list_right" style="width:90%;border-left: 0px ridge #464;">
			
				<div id="book_list" class="list_r_title">
				
					<input type="hidden" id="page" value="${page}" />
					<input type="hidden" id="searchhi" value="${searchval}" />
					<div id="divTopPageNavi" class="list_r_title_text3" style="padding: 0px 0px">
					<form action="search" method="post" style="display:inline;">
								<div style="padding: 8px 20px;display:inline;">
									<script type="text/javascript">
									
											var filediv=0;
											var cou=0;
										$(function() {
										$("#pagediv").fadeOut(2000);
											var i = $("#inputtext");
											var n1 = $("#numinputdiv1");
											var n = $("#numinputdiv");
											i.keyup(function() {
												if (i == "") {
													divch(n1, 0, n, "");
												} else {
													divch(n1, 1, n, i.val());
												}
											});
											i.blur(function() {
												divch(n1, 0, n, "");
											});
											i.focus(function() {
												if (i == "") {
													divch(n1, 0, n, "");
												} else {
													divch(n1, 1, n,i.val());
												}
											});
											$(".aen").click(function(){
												$(this).attr("href",$(this).attr("href")+"&searchval="+encodeURIComponent(encodeURIComponent($("#searchhi").val())));
												
												});
											for(var o=0;o<$(".linkname").size();o++){
											$(".linkname").eq(o).html($(".linkname").eq(o).html()
												.replace($("#searchhi").val(),'<b><font color=red>'+$("#searchhi").val()+'</font></b>'));
											}
											
											$(".stylediv").hover(function(){
												if(filediv==0||$(this).parent().children("b").html()!=cou){
													$(this).css("background-color","#9BE").css("opacity","1");
													$(this).parent().children("a").css("background-color","#FF5");
												}
												
											},function(){
												if(filediv==0||$(this).parent().children("b").html()!=cou){
													$(this).css("background-color","#484").css("opacity","0.7");
													$(this).parent().children("a").css("background-color","#ccef9e");
												}
											});
											
											$(".stylediv").click(function() {
												if($(this).css("position")=="absolute"){
													down($(this));
													filediv=1;
													cou=$(this).parent().children("b").html();
												}else{
													up($(this));
													filediv=0;
													cou=0;
												}
											});
											
											
										});
										function down(obj){
											var backdiv=$(".stylediv").parent().children(".stylediv").eq(cou-1);
											if(cou!=0){
											up(backdiv);
											}
											
											obj.slideUp("slow",function(){
												obj.css("position","static").css("background-color","#9BE").css("opacity","1");
											}).slideDown("slow");
											var childrendiv=obj.children("span").children("span").children("div");
											childrendiv.hide();
											obj.parent().children("a").fadeOut("slow",function(){
												obj.parent().children("a").css("font-size","28px").fadeIn("slow").css("background-color","#ccef9e");
												childrendiv.fadeIn(1000);
											});
										}
										function up(obj){
											obj.slideUp(400,function(){
											obj.css("position","absolute");
											}).slideDown(700).css("background-color","#484").css("opacity","0.7");
											obj.parent().children("a").fadeOut("slow",function(){
												obj.parent().children("a").css("font-size","14px").fadeIn("slow");
											});
										}
										function divch(obj1, opa, obj2, val) {
											obj1.css("opacity", opa);
											obj2.html(val);
										}
										
									</script>
									<input id="inputtext" placeholder="输入你要搜索的关键字" name="searchval"
										value="${searchval}" /> <input type="submit" value="&nbsp;&nbsp;搜索" style="background: url('../images/default08temp/search1.gif') top left  repeat-y"/>
									<div id="numinputdiv1" style="opacity:0;background-color:#AAA;padding: 0px 0px 2px 0px;position:absolute;width:150px">
										<div style="padding:5px 5px;border:1px solid #9bb17e;background-color:#EEE;height:100%;color:blue;font-size:18px" id="numinputdiv">
										</div>
									</div>

								</div>
							</form>
						
						<!--分页导航开始-->
						
						<div style="display:inline;" id="adiv">
						
							<s:if test="page<=1">
								<img src='../images/page_up_gray.gif' style="display: inline;" />
							</s:if>
							<s:else>
								<a href="search?page=${page-1}" class="aen"> <img
									src='../images/page_up.gif' style="display: inline;" /> </a>
							</s:else>
							［共
							<s:property value="totolPages" />
							页］

							<s:if test="page>=totolPages">
								<img src='../images/page_down_gray.gif' style="display: inline;" />
							</s:if>
							<s:else>
								<a href="search?page=${page+1}" class="aen"> <img
									src='../images/page_down.gif' style="display: inline;" /> </a>
							</s:else>


							<a href="search?page=1"  class="aen"><b><font size=2px color=blue>首页</font>
							</b> </a>
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
											<a href="search?page=${p}" class="aen"><font color=blue>${p}</font> </a>
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
							<a href="search?page=${totolPages}" class="aen"><b><font size=2px
									color=blue>尾页</font> </b> </a>

						</div>



						<!--分页导航结束-->
					</div>
				</div>
				<s:if test="books.size()==0">
					<div style="width: 700px; height: 500px;">
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<div class="list_r_list">没有符合条件的商品！</div>
						<div class="clear"></div>
						<div id="divBottomPageNavi" class="fanye_bottom"></div>
					</div>

				</s:if>
				<s:else>
				<div style="background:#ccef9e url(../1images/note.jpg) top left  repeat-y;border-left: 0px dotted #739a73;
				padding: 20px 50px;width:80%;">
				<font size=4px><b>搜索结果：</b></font><br/><br/>
					<s:iterator value="books" status="s">

						<!--商品条目开始-->
						<div style="position:relative;background-color:#ccef9e;border-right: 13px solid #aacd7c;border-top: 20px solid #aacd7c;border-bottom: 5px solid #777;border-left: 20px dashed #ccef9e;width:100px;display:inline-table;">
						<div class="list_r_line" ></div>
						<div class="clear" ></div><b class="count"><s:property value="(page-1)*pagesize+#s.count"/></b>、
<a name="link_prd_name" class="linkname" href='#' style="text-align:center;font-size:14px;color:#000">
								${productname}</a>
						<div  style="opacity:0.7;background-color:#484;margin: 25px 20px;border: 8px solid #030;position:absolute;" class="stylediv">
							<span style="display:inline;"><a name="link_prd_img"
								href='#'> <img src="../productImages/${productpic}" style="display:inline;width:20%"/> </a>
								<span style="position: absolute;display:inline;">ID:${id}
						<div  style="background-color:#EEF;margin: 20px 20px;border: 8px solid #FFF;width:100%;" >
							
							<h3>顾客评分：100</h3>
								作 者: <a href='#' name='作者'>${author}</a>
						
							<h4>
								出版社： <a href='#' name='出版社' class="linkname">${publishing}</a>
							</h4>
							<h4>出版时间：${publish_time}</h4>
							<h5 class="linkname">简介：${catalogue}</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${fixed_price}</span>
								<span class="red">￥${dang_price}</span>
								<a href="#" class="buy" id="${id}"> 
								<img	src='../images/buttom_goumai.gif' style="display:inline"/> </a> 
									<span id="cartinfo"></span>
									节省：￥ <font color="red" size=3px>${fixed_price-dang_price}</font>
							</h6>
							</div><br/>
								</span></span>
								
								
						</div>

						<!--商品条目结束-->
						<div class="clear"></div>
						<div id="divBottomPageNavi" class="fanye_bottom">
						
						
						
						
						</div>


				</div>
					</s:iterator>
			
			
						<!--商品条目开始-->
						<div style="position:relative;background-color:#aacd7c;border: 17px solid #aacd7c;width:100px;height:170px;display:inline-table;">
						
							<br/>
								
						<!--商品条目结束-->
						<div class="clear"></div>
						<div id="divBottomPageNavi" class="fanye_bottom">
						</div>


				</div>
			
			
			
			
			
			
			
					</div>
					
					
				</s:else>
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
