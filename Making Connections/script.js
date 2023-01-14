function FnRefuse(id){
    document.getElementById(id).remove();
    var e=document.getElementById('reqnum');
    e.innerText --;
}
function FnAccept(id){
    document.getElementById(id).remove();
    var e=document.getElementById('cnxnum');
    e.innerText ++;

}

function changeitem(id){
    document.getElementById(id).innerText="jannet";
}