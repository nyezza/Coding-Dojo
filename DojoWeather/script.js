function ChangeCity(){
    alert("Loading Weather report");
}

function RmPopup(){
    document.querySelector(".footer").remove();
}

function ConvertTmp(){
    var x= document.querySelector("#tday").innerText;
    console.log(x);
    var yy= document.querySelector("#night").innerText;
    console.log(x);
/*
    var y = document.getElementById("temp-select").innerText;
    console.log(y);
    if ((document.getElementById("temp-select")) == '°F'){
        var y= x + 32;
        console.log(y);
    }
    document.getElementById(id).innerText=y;
}
