console.log("page loaded...");
//xmlns="http://www.w3.org/2000/svg"
function play(x){
    var x = document.getElementById(id);
    document.getElementById(id).innerText= "start:"+ x.played.start(0) + "end:" + x.played.end(0);
}
function VideoPlay(e){
    e.play();
}

function VideoPause(e){
    e.pause();
}

function ChangeMuteFalse(e){
    e.muted=false;
}
    
function ChangeMuteTrue(e){
    e.muted=true;
}
    