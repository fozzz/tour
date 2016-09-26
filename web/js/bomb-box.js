// JavaScript Document
function Elastic()
{
 var shit = !-[1, ];
 var oWin = document.getElementById("win");
 var oLay = document.getElementById("overlay"); 
 var oClose = document.getElementById("close");
 var bDrag = false;
 var disX = disY = 0;
 var iScrollT = document.documentElement.scrollTop || document.body.scrollTop;
 var iScrollL = document.documentElement.scrollLeft || document.body.scrollLeft;
 oBtn();
 function oBtn()
 {
  oLay.style.display = "block";
  oWin.style.display = "block";
  shit && (oLay.style.height = document.body.offsetHeight + "px");
 };
 oClose.onclick = function ()
 {
  oLay.style.display = "none";
  oWin.style.display = "none"; 

  
 };
 oClose.onmousedown = function (event)
 {
  (event || window.event).cancelBubble = true;
 };
 document.onmousemove = function (event)
 {
  if (!bDrag) return;
  var event = event || window.event;
  var iL = event.clientX - disX + iScrollL;
  var iT = event.clientY - disY + iScrollT;
  var maxL = document.body.clientWidth - oWin.offsetWidth;
  var maxT = document.body.clientHeight - oWin.offsetHeight;  
  iL = iL < 0 ? 0 : iL;
  iL = iL > maxL ? maxL : iL;   
  iT = iT < 0 ? 0 : iT;
  iT = iT > maxT ? maxT : iT;
  
  oWin.style.marginTop = oWin.style.marginLeft = 0;
  oWin.style.left = iL + "px";
  oWin.style.top = iT + "px";  
  return false
 };
};