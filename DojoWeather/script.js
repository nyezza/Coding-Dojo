function ChangeCity(){
    alert("Loading Weather report");
}

function RmPopup(){
    document.querySelector(".footer").remove();
}

function ConvertTmp(id){
    var x= document.getElementById(id).innerText;
    if ((document.getElementById("temp-select")) == '°F'){
        var y= sum(x,32);
    }
    document.getElementById(id).innerText=y;
}