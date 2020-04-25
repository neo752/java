<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../common/taglib.jsp"%>


<%--   左侧分类   --%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
				<s:iterator value="cats">
			<!--2级分类开始-->

			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[
					<a href="#">${name}</a>]
				</h3>
				<ul class="ul_left_list">
					<s:iterator value="subCats">
						<!--3级分类开始-->
						<li>
							<a href="#">${name}</a>

						</li>
						<!--3级分类结束-->
					</s:iterator>
				</ul>
				<div class="empty_left">

				</div>
			</div>

			<div class="more2">
			</div>
			
			<!--2级分类结束-->
			
			</s:iterator>
		
			
		

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
