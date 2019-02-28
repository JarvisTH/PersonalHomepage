function BrowserType()
{
	var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
	var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
	var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
	var isEdge = userAgent.indexOf("Edge") > -1; //判断是否IE的Edge浏览器
	var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
	var isSafari = userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") == -1; //判断是否Safari浏览器
	var isChrome = userAgent.indexOf("Chrome") > -1 && userAgent.indexOf("Safari") > -1; //判断Chrome浏览器
	if (isFF) { return "FF";}
	if (isOpera) { return "Opera";}
	if (isSafari) { return "Safari";}
	if (isEdge) { return "Edge";}
	if (isChrome) { return "Chrome";}
	
}



if(BrowserType()=="Edge")
{
	document.getElementById("img-show").style.top=405+"px";
}
if(BrowserType()=="Chrome")
{
	document.getElementById("img-show").style.top=405+"px";
}

