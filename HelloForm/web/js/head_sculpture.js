window.onload=function(){
    var oDiv_head_sculpture=document.getElementById("head-sculpture");

    oDiv_head_sculpture.onmouseover=function () {
        oDiv_head_sculpture.style.borderColor="skyblue";
    }

    oDiv_head_sculpture.onmouseout=function () {
        oDiv_head_sculpture.style.borderColor="slategray";
    }
}