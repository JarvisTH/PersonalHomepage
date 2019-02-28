window.onload=function () {
    var codeBtn=document.getElementById("code-btn");
    var phone=document.getElementById("input-phone");


    codeBtn.onclick=function (ev) {
        if(phone==null){
            alert("号码不能为空！");
        }else{
            var str=phone.value;

            codeBtn.innerText="<%=(new UserLoginServlet().getCode("+str+"))%>";
        }
    }
}