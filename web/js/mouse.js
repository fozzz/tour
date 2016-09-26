// JavaScript Document
//以下为参数说明
//parentNodeID:Li的UL的ID, 要是没有特别的，这个也可以不写
//selfObj:this
//showContentPrefix:对应要显示的Content的ID的前缀
//showContentIndex:要显示第几个Content,
//showClassName:自己显示时的class 名称
function selectSwtich(parentNodeID,selfObj,showContentPrefix,showContentIndex,showClassName)
{
	//alert(parentNodeID);
	//获取一共有几个要切换的Li
	var tag;
	if(parentNodeID=="")
	{
		tag =selfObj.parentNode.getElementsByTagName("li");
	}
	else
	{
		 tag = document.getElementById(parentNodeID).getElementsByTagName("li");
	}
	
	//让所有的li 和对应的内容 都不显示
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
		document.getElementById(showContentPrefix+i).style.display="none";
	}
	
	//让自己的li显示，让对应的Content显示
	selfObj.className = showClassName;
	document.getElementById(showContentPrefix+showContentIndex).style.display = "block";
	
}