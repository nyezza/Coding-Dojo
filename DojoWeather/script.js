function ChangeCity(){
    alert("Loading Weather report");
}

function RmPopup(){
    document.querySelector(".footer").remove();
}

function ConvertTmp(id){
    var x= document.getElementById(id).innerText;
    console.log(x);
    if ((document.getElementById("temp-select")) == '°F'){
        var y= x + 32;
        console.log(y);
    }
    document.getElementById(id).innerText=y;
}