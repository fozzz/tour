// JavaScript Document
// JavaScript Document
//<![CDATA[
$(document).ready(function(){					   
$(".item1").hover(function(){$("#tit_fc1").slideDown("normal");	}, function() {$("#tit_fc1").slideUp("fast");});				
$(".item2").hover(function(){$("#tit_fc2").slideDown("normal");	}, function() {$("#tit_fc2").slideUp("fast");});
$(".item3").hover(function(){$("#tit_fc3").slideDown("normal");	}, function() {$("#tit_fc3").slideUp("fast");});
$(".item4").hover(function(){$("#tit_fc4").slideDown("normal");	}, function() {$("#tit_fc4").slideUp("fast");});
});			   
var currentindex=1;
$("#flashBg").css("background-color",$("#flash1").attr("name"));
function changeflash(i) {	
currentindex=i;
var flash = $("#text div");
for (j=1;j<=flash.length;j++){//此处的flash.length代表你想要添加的幻灯片的数量与下面的IMG相呼应
	if (j==i){
    $("#text"+j).fadeIn("normal");
	$("#text"+j).css("display","block");
	$("#f"+j).removeClass();
	$("#f"+j).addClass("dq");
	$("#flashBg").css("background-color",$("#flash"+j).attr("name"));
	}
	else
	{
    $("#text"+j).css("display","none");
	$("#f"+j).removeClass();
	$("#f"+j).addClass("no");
	}
}}
function startAm(){
timerID = setInterval("timer_tick()",3000);//3000代表间隔时间设置
}
function stopAm(){
clearInterval(timerID);
}
function timer_tick() {
	var DIV = $("#text div").length; //选取要循环图片的个数
    currentindex=currentindex>=DIV?1:currentindex+1;//此处的IMG代表幻灯片循环遍历的次数
	changeflash(currentindex);}
$(document).ready(function(){
$(".flash_bar div").mouseover(function(){stopAm();}).mouseout(function(){startAm();});
startAm();
});

 //]]>