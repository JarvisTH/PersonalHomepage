var oDiv_left=document.getElementById("left");
var oDiv_right=document.getElementById("right");

var oImg_left=document.getElementById("left-img");
var oImg_right=document.getElementById("right-img");

var oImg_show=document.getElementById("img-id");

var oDiv_img_show=document.getElementById("img-show");

var timer=setInterval("upDateImg()",3000);



oDiv_img_show.onmousemove=function()
{
	oDiv_left.style.visibility="visible";
	oDiv_right.style.visibility="visible";
	if(timer!=null)
	{
		clearInterval(timer);
	}
}

oDiv_img_show.onmouseout=function()
{
	oDiv_left.style.visibility="hidden";
	oDiv_right.style.visibility="hidden";
	timer=setInterval("upDateImg()",3000);
}


oDiv_left.onclick=function()
{
	clickLeft();
}

oDiv_right.onclick=function()
{
	clickRight();
}


function upDateImg()
{
	var str=oImg_show.src;
	var arr=str.split("/");
	index=arr[arr.length-1];
	switch(index)
	{
		case "01.jpg":
			oImg_show.src="img/02.jpg";
			index="02.jpg";
			break;
		case "02.jpg":
			oImg_show.src="img/03.jpg";
			index="03.jpg";
			break;
		case "03.jpg":
			oImg_show.src="img/01.jpg";
			index="01.jpg";
			break;
	}
}

function clickLeft()
{
	var str=oImg_show.src;
	var arr=str.split("/");
	index=arr[arr.length-1];
	switch(index)
	{
		case "01.jpg":
			oImg_show.src="img/03.jpg";
			index="03.jpg";
			break;
		case "02.jpg":
			oImg_show.src="img/01.jpg";
			index="01.jpg";
			break;
		case "03.jpg":
			oImg_show.src="img/02.jpg";
			index="02.jpg";
			break;
	}
}

function clickRight()
{
	var str=oImg_show.src;
	var arr=str.split("/");
	index=arr[arr.length-1];
	switch(index)
	{
		case "01.jpg":
			oImg_show.src="img/02.jpg";
			index="02.jpg";
			break;
		case "02.jpg":
			oImg_show.src="img/03.jpg";
			index="03.jpg";
			break;
		case "03.jpg":
			oImg_show.src="img/01.jpg";
			index="01.jpg";
			break;
	}
	
}

