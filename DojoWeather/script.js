function ChangeCity(){
    var e= document.querySelector(".nav-bar button").innerText;
    alert(" Weather report for"%e );
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
        document.getElementById(id).innerText=(y);
        
    }
}
