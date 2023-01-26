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
function ConvertTmp(){
    var x= document.getElementById(id).innerText;
    console.log(x);
    //var y=document.querySelector("#temp-select option" ).innerText;
    console.log(y);
    var y=document.querySelector('.temp-select' );
    console.log(y);
    y= addEventListener('change',(event) => {
        if ((document.getElementById("temp-select")) == '°F'){
                var y= x + 32;
                console.log(y);
                document.getElementById(id).innerText=(y);
    
            }
        })
}