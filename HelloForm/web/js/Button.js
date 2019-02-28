
	var oBtn_bigger=document.getElementById("bigger");
	var oBtn_smaller=document.getElementById("smaller");
	var oImg=document.getElementById("touxiang");
	
	oBtn_bigger.onmousemove=function()
	{
		oBtn_bigger.style.backgroundColor="#808000";
	}
	
	oBtn_smaller.onmousemove=function()
	{
		oBtn_smaller.style.backgroundColor="#808000";
	}
	
	oBtn_bigger.onmouseout=function()
	{
		oBtn_bigger.style.backgroundColor="lightskyblue";
	}
	
	oBtn_smaller.onmouseout=function()
	{
		oBtn_smaller.style.backgroundColor="lightskyblue";
	}
	
	oBtn_bigger.onclick=function()
	{
		oImg.style.width=oImg.offsetWidth+5+"px";
		oImg.style.height=oImg.offsetHeight+5+"px";
	}
	
	oBtn_smaller.onclick=function()
	{
		oImg.style.width=oImg.offsetWidth-5+"px";
		oImg.style.height=oImg.offsetHeight-5+"px";
	}
