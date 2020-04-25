//书籍详细页面
function gethtml(num){
	$("#buydiv").load("findbookbyid?bookid="+num,function(){
		var htmlvalset="数据加载失败！请稍后重试！"
		var hei="100px";
		var wid="200px";
		if($("#buydiv").html()!=""){
			htmlvalset=$("#buydiv").html();
			hei=(parseInt($("#buydiv").css("height"))+50)+"px";
			wid=(parseInt($("#buydiv").css("width"))+50)+"px";
		}
		myshowdiv("BOOK详细INFO",htmlvalset
				,"default","default","default",wid,hei);
	});
	
}
//订单详细页面显示
function getitem(num){
	$("#orderdivs").load("item_info?order.id="+num,function(){
		var htmlvalset="数据加载失败！请稍后重试！"
		var hei="500px";
		var wid="800px";
		if($("#orderdivs").html()!=""){
			htmlvalset=$("#orderdivs").html(); 
			if((parseInt($("#orderdivs").css("height"))+50)>500){
				hei=(parseInt($("#orderdivs").css("height"))+50)+"px";
			}
			if((parseInt($("#orderdivs").css("width"))+50)>800){
				wid=(parseInt($("#orderdivs").css("width"))+50)+"px";
			}
			
			
		}
		myshowdiv("订单详情",htmlvalset
				,"default","default","default",wid,hei);
	});
	
}