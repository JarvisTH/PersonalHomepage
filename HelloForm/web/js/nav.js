window.onload=function()
{
	var oInfo=document.getElementById("info");
	var oPhone=document.getElementById("phone");
	var oEdu=document.getElementById("edu");
	var oExp=document.getElementById("exp");
	
	var oSection_1=document.getElementById("content-1");
	var oSection_2=document.getElementById("content-2");
	var oSection_3=document.getElementById("content-3");
	var oSection_4=document.getElementById("content-4");
	
	var top="section_1";
	
	oInfo.onmousemove=function()
	{
		oInfo.style.backgroundColor="#808000";
	}
	
	oPhone.onmousemove=function()
	{
		oPhone.style.backgroundColor="#808000";
	}
	
	oEdu.onmousemove=function()
	{
		oEdu.style.backgroundColor="#808000";
	}
	
	oExp.onmousemove=function()
	{
		oExp.style.backgroundColor="#808000";
	}
	
	oInfo.onmouseout=function()
	{
		oInfo.style.backgroundColor="lightskyblue";
	}
	
	oPhone.onmouseout=function()
	{
		oPhone.style.backgroundColor="lightskyblue";
	}
	
	oEdu.onmouseout=function()
	{
		oEdu.style.backgroundColor="lightskyblue";
	}
	
	oExp.onmouseout=function()
	{
		oExp.style.backgroundColor="lightskyblue";
	}
	
	oInfo.onclick=function()
	{
		if(top!="section_1")
		{
			switch(top)
			{
				case "section_2":
					oSection_2.style.zIndex=-1;
					break;
				case "section_3":
					oSection_3.style.zIndex=-1;
					break;
				case "section_4":
					oSection_4.style.zIndex=-1;
					break;
			}
			oSection_1.style.zIndex=999;
			top="section_1";
		}
		
	}
	
	oPhone.onclick=function()
	{
		if(top!="section_2")
		{
			switch(top)
			{
				case "section_1":
					oSection_1.style.zIndex=0;
					break;
				case "section_3":
					oSection_3.style.zIndex=0;
					break;
				case "section_4":
					oSection_4.style.zIndex=0;
					break;
			}
			oSection_2.style.zIndex=999;
			top="section_2";
		}
	}
	
	oEdu.onclick=function()
	{
		if(top!="section_3")
		{
			switch(top)
			{
				case "section_1":
					oSection_1.style.zIndex=0;
					break;
				case "section_2":
					oSection_2.style.zIndex=0;
					break;
				case "section_4":
					oSection_4.style.zIndex=0;
					break;
			}
			oSection_3.style.zIndex=999;
			top="section_3";
		}
	}
	
	oExp.onclick=function()
	{
		if(top!="section_4")
		{
			switch(top)
			{
				case "section_1":
					oSection_1.style.zIndex=0;
					break;
				case "section_2":
					oSection_2.style.zIndex=0;
					break;
				case "section_3":
					oSection_3.style.zIndex=0;
					break;
			}
			oSection_4.style.zIndex=999;
			top="section_4";
		}
	}
}