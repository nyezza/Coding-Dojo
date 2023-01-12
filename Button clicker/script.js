function likes(e){
    console.log(e);
    e.innerText ++;
    alert("ninja was liked")
}
function remouve(id){
    document.getElementById(id).remove()
}
function changetext(id){
    e=document.getElementById(id)
    e.innerText="logout"
}

