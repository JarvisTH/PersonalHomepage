
	var oImg_hour_1=document.getElementById("hour_1");
	var oImg_hour_0=document.getElementById("hour_0");
	var oImg_min_1=document.getElementById("min_1");
	var oImg_min_0=document.getElementById("min_0");
	var oImg_sec_1=document.getElementById("sec_1");
	var oImg_sec_0=document.getElementById("sec_0");
	
	var oDate=document.getElementById("date");
	var oTime=document.getElementById("time");
	
	
	function upDateTime()
	{
			var now=new Date();
			var year=now.getFullYear();
			var month=now.getMonth()+1;
			var day=now.getDate();
			var hour=now.getHours();
			var min=now.getMinutes();
			var sec=now.getSeconds();
			oDate.value=year+"年"+month+"月"+day+"日";
			oTime.value=hour+":"+min+":"+sec;
			
			var hour_1=parseInt(hour/10);
			
			switch(hour_1)
			{
			case 0:
				oImg_hour_1.src="img/0.png";
				break;
			case 1:
				oImg_hour_1.src="img/1.png";
				break;
			case 2:
				oImg_hour_1.src="img/2.png";
				break;
			}
			
			var hour_0=parseInt(hour%10);
			switch(hour_0)
			{
				case 0:
					oImg_hour_0.src="img/0.png";
					break;
				case 1:
					oImg_hour_0.src="img/1.png";
					break;
				case 2:
					oImg_hour_0.src="img/2.png";
					break;
				case 3:
					oImg_hour_0.src="img/3.png";
					break;
				case 4:
					oImg_hour_0.src="img/4.png";
					break;
				case 5:
					oImg_hour_0.src="img/5.png";
					break;
				case 6:
					oImg_hour_0.src="img/6.png";
					break;
				case 7:
					oImg_hour_0.src="img/7.png";
					break;
				case 8:
					oImg_hour_0.src="img/8.png";
					break;
				case 9:
					oImg_hour_0.src="img/9.png";
					break;
				}
			
			var min_1=parseInt(min/10);
			switch(min_1)
			{
				case 0:
					oImg_min_1.src="img/0.png";
					break;
				case 1:
					oImg_min_1.src="img/1.png";
					break;
				case 2:
					oImg_min_1.src="img/2.png";
					break;
				case 3:
					oImg_min_1.src="img/3.png";
					break;
				case 4:
					oImg_min_1.src="img/4.png";
					break;
				case 5:
					oImg_min_1.src="img/5.png";
					break;
				}
			
			var min_0=parseInt(min%10);
			switch(min_0)
			{
				case 0:
					oImg_min_0.src="img/0.png";
					break;
				case 1:
					oImg_min_0.src="img/1.png";
					break;
				case 2:
					oImg_min_0.src="img/2.png";
					break;
				case 3:
					oImg_min_0.src="img/3.png";
					break;
				case 4:
					oImg_min_0.src="img/4.png";
					break;
				case 5:
					oImg_min_0.src="img/5.png";
					break;
				case 6:
					oImg_min_0.src="img/6.png";
					break;
				case 7:
					oImg_min_0.src="img/7.png";
					break;
				case 8:
					oImg_min_0.src="img/8.png";
					break;
				case 9:
					oImg_min_0.src="img/9.png";
					break;
				}
			
			var sec_1=parseInt(sec/10);
			switch(sec_1)
			{
				
				case 0:
					oImg_sec_1.src="img/0.png";
					break;
				case 1:
					oImg_sec_1.src="img/1.png";
					break;
				case 2:
					oImg_sec_1.src="img/2.png";
					break;
				case 3:
					oImg_sec_1.src="img/3.png";
					break;
				case 4:
					oImg_sec_1.src="img/4.png";
					break;
				case 5:
					oImg_sec_1.src="img/5.png";
					break;
				}
			
			var sec_0=parseInt(sec%10);
			switch(sec_0)
			{
				
				case 0:
					oImg_sec_0.src='img/0.png';
					break;
				case 1:
					oImg_sec_0.src="img/1.png";
					break;
				case 2:
					oImg_sec_0.src="img/2.png";
					break;
				case 3:
					oImg_sec_0.src="img/3.png";
					break;
				case 4:
					oImg_sec_0.src="img/4.png";
					break;
				case 5:
					oImg_sec_0.src="img/5.png";
					break;
				case 6:
					oImg_sec_0.src="img/6.png";
					break;
				case 7:
					oImg_sec_0.src="img/7.png";
					break;
				case 8:
					oImg_sec_0.src="img/8.png";
					break;
				case 9:
					oImg_sec_0.src="img/9.png";
					break;
					
				}
			
	}

	
	setInterval("upDateTime()",1000);	
	

