function FnRefuse(id){
    document.getElementById(id).remove();
    var e1=document.getElementById('reqnum');
    e.innerText --;
}
function FnAccept(id){
    document.getElementById(id).remove();
    var e=document.getElementById('cnxnum');
    e.innerText ++;
    var e1=document.getElementById('reqnum');
    e1.innerText --;


}

function changeitem(id){
    document.getElementById(id).innerText="jannet";
}