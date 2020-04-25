//＝＝＝＝＝（一）定义一个弹出对话框,default为默认项，即不进行更改。


function myshowdiv(){	
	var winw =  $(window).width();
	var winh = $(window).height();
	var wint = $(document).scrollTop();
	var msg=new Array;
	msg[0]="输入标题";//0、标题  
	msg[1]="这里输入内容";//1、内容
	msg[2]="../images/sys/warning.gif";//2、退出按钮图片地址
	msg[3]="0.5";// 3、底层透明度
	msg[4]="#000";//  4、底层颜色 
	msg[5]="500px";//  5、上层宽度
	msg[6]="100px";// 6、上层高度
	msg[7]="#77C";//  7、标题背景
	msg[8]="#FFF";// 8、内容背景
	msg[9]="#FFF";//   9、标题字体颜色
	msg[10]="#000";//10、内容字体颜色
	for(var i=0;i<arguments.length;i++){
		if(arguments[i]!="default"){
		msg[i]=arguments[i];}
	}
	//定义模板
	$("body").prepend("<div style='display:none;position: fixed;top: 0px;left: 0px;z-index: 99999998;background-color: "
			+msg[4]+";opacity: "+msg[3]+";' id='autoprependdiv0'>" +
			"</div><div id='autoprependdiv1' style='display:none;width: "+msg[5]+";background-color:"+msg[8]+";height: 0px;position: absolute;z-index: 99999999;top: 0px;left: 0px;" +
			"border-bottom: 2px solid #333;border-left: 2px solid #EEE;border-right: 2px solid #666;border-top: 2px solid #AAA;'>" +
			"<div id='autoprependdivup' style='background-color:"+msg[7]+";height:30px;''><font color="+msg[9]+" size=4px><b>"+msg[0]+"</b> </font>" +
			"<a href='javascript:;' onclick='autoexita();'>" +
			"<img src='"+msg[2]+"' title='退出' alt='退出' style='position:absolute;top:0px;right:0px;z-index: 199999998' />" +
			"</a></div><div id='autoprependdivdown' style='color:"+msg[10]+"'>"+msg[1]+"</div></div>");
	//定义弹出
	$("#autoprependdiv0").css("height", winh).css("width", winw)
			.fadeIn(600);
	$("#autoprependdiv1").css("display","block")
		.animate({height:"0px",top:(wint +winh)/2+ "px",
		left:(winw  - parseInt(msg[5]))+ "px"},300 )
		.animate({height:msg[6],top:(wint +winh/2- parseInt(msg[6]) / 2)+ "px",
				left:(winw / 2 - parseInt(msg[5]) / 2)+ "px"},500 );
	
	//$("#autoprependdiv1").css("left",((winw / 2 - parseInt($("#autoprependdiv1").css("width")) / 2))+ "px")
	//	.css("top",((wint +winh/2- parseInt($("#autoprependdiv1").css("height")) / 2))+ "px")
	//	.fadeIn(200);
	//定义弹框移动事件
	var move=0;
	var xx=0;
	var yy=0; 
	var l=0;
	var t=0;
	$("#autoprependdivup").mousedown(function(e){
	xx=e.pageX;
	yy=e.pageY;
	var div0=$("#autoprependdiv1");
	l=div0.css("left");
	t=div0.css("top");
	$("#autoprependdiv1").css("background-color","");
	$("#autoprependdivdown").css("display","none");
	$("*").css("cursor","move");
		move=1;
	});
	$("#autoprependdivup").mouseup(function(){
		$("#autoprependdivdown").css("display","block");
		$("#autoprependdiv1").css("background-color",msg[8]);
		$("*").css("cursor","");
			move=0;
		});
	$("*").mousemove(function(e){
		if(move==1){
			var div0=$("#autoprependdiv1");
			var x=parseInt(e.pageX)-parseInt(xx)+parseInt(l);
			var y=parseInt(e.pageY)-parseInt(yy)+parseInt(t);
			div0.css("top", y+"px")
					 .css("left", x+"px"); 
		
		}
	});

}

//定义关闭
function autoexita() {
	$("#autoprependdiv1").slideUp(200,function(){
		$("#autoprependdiv0").fadeOut(200,function(){
			$("#autoprependdiv1").remove();
			$("#autoprependdiv0").remove();
		});
		
	});
	
}

//＝＝＝＝＝（二）被调用类方法
function mfn(){
	var mmf=$("#autoprependdivdown").children("font").children("input").val();
	var name=$("#autoprependdivdown").children("table").children("tbody").children("tr").children("td").eq(2).children("a");
	name.attr("href",name.attr("href")+mmf);
};
//＝＝＝＝＝（三）管理员相关
$(function(){
	var oldid=-1;
	$(".tbodystyle").children("tr").hover(function(){
		$(this).css("background-color","#446").css("color","#FFF");
	},function(){
		$(this).css("background-color","#CCA").css("color","#000");
	});
	//双击
	$(".tbodystyle").children("tr").children("td").dblclick(function(){
		var len;
		if($(this).children("input").attr("value").length==0){
			len=1;
		}else{
			if(/^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*$/.test($(this).children("input").attr("value"))){
				len=$(this).children("input").attr("value").length*2;
			}else{
				len=$(this).children("input").attr("value").length;
			}
		}
		if($(this).parent().children("td").children("input").val()==$(this).children("input").val()){
			oldid=$(this).children("input").attr("value");
		}
		$(this).html("<input value='"+$(this).children("input").attr("value")
				+"' size="+len+" name='"+$(this).children("input").attr("name")+"'>");
	});
	//表更改
	$(".AdminModify").click(function(){
		var table=$(this).parent().parent().children("td").children("input");
		var arr={};
		for(var i=0;i<table.length-2;i++){
			arr[table.eq(i).attr("name")]=table.eq(i).val();
		}
		arr["tabletype"]=$("#tabletype").val();
		if(oldid==-1){
			oldid=table.eq(0).val();
		}
		arr["oldid"]=oldid;
		$("#table_msg").html("开始更改");
		$.post("adminModify",arr,function(){
			$("#showdivs").load("showtable"+$("#tabletype").val());
			$("#table_msg").html("表中字段名后数字为权限等级");
		});
	});
	//表删除
	$(".AdminDel").click(function(){
		var table=$(this).parent().parent().children("td").children("input");
		var arr={};
		arr[table.eq(0).attr("name")]=table.eq(0).val();
		arr["tabletype"]=$("#tabletype").val();
		$("#table_msg").html("开始删除");
		$.post("adminDel",arr,function(){
			$("#showdivs").load("showtable"+$("#tabletype").val());
			$("#table_msg").html("表中字段名后数字为权限等级");
		});
	});
	//表增加
	$("#AdminAdd").click(function(){
		var val="<form action='adminAdd' method='post'  id='formac'><input type='hidden' value='"+$("#tabletype").val()+"' name='tabletype'><br/>";
		var ziduan=$(".theadstyle").children("tr").children("td");
		var ziduanname=$(".tbodystyle").children("tr").children("td").children("input");
		for(var i=0;i<ziduan.length-1;i++){
			val+=ziduan.eq(i).html()+"：<input name='"+ziduanname.eq(i+1).attr("name")+"'><br>";
		}
		val+="<input type='submit' value='增加'></form>";
		myshowdiv("添加"+$("#tabletype").val()+"表数据",
				val,"default","default","default","default","50%");
	});
	
});
//购买按钮
$(function(){
	$(".td_no_bord").hover(function(){
		$(this).css("background-color","#ABC");
	},function(){
		$(this).css("background-color","#FFF");
		
	});
	//修改数量按钮
			$(".modifycart").children("a:even").click(function(){
				var tdspan=$(this).parent("td").prev().children("span");
				var id=$(this).parent("td").parent("tr").children("td").html();
					$.post("modifycart",{"qtytype":1,"id":id},function(data){
						tdspan.html(parseInt(tdspan.html())+1);
						$("#total_account").html(data);
						$.post("gettotalAndtakeprice",function(take){
								$("#total_economy").html(take);
						});
					});
					
				return false;
		});
		$(".modifycart").children("a:odd").click(function(){
				var tdspan=$(this).parent("td").prev().children("span");
				var id=$(this).parent("td").parent("tr").children("td").html();
					$.post("modifycart",{"qtytype":0,"id":id},function(data){
					if(tdspan.html()<=1){
							tdspan.html(1);
						}else{
							tdspan.html(parseInt(tdspan.html())-1);
								$("#total_account").html(data);
								$.post("gettotalAndtakeprice",function(take){
									$("#total_economy").html(take);
								});
						} 
						
					});
				return false;
		});
		
	});


