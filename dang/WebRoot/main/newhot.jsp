<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>
<script type="text/javascript" src="../js/jquery-1.7.js"></script>
<script type="text/javascript">
	$(function(){
		$(".rightdd:odd").css("background-color","#fef5dd").css("border","1px solid #fef5dd");
		$(".rightdd:even").css("background-color","#ede4cc").css("border","1px solid #ede4cc");
		$(".rightdd").hover(function(){
			$(this).css("border","1px solid #888");
		},function(){
		$(".rightdd:odd").css("border","1px solid #fef5dd");
		$(".rightdd:even").css("border","1px solid #ede4cc");
		});

	});
</script>
	<div id="buydiv" style="display:none"></div>
<div id="buylist">
								<s:if test="plist.size()==0">
									没有找到匹配记录！
								</s:if>
								<s:else>
									<s:iterator value="plist" status="c">
									<div style="width:208px;border:1px solid #fef5dd;" class="rightdd">
										<div><a href="javascript:;" class="buybook" name="${id}">${c.count}、${productname}</a></div>
										<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											${addtime}&nbsp;&nbsp;&nbsp;已售<font color=red>${countnum}</font>本
										</div>
										
									</div>
									</s:iterator>
								</s:else>
								</div>