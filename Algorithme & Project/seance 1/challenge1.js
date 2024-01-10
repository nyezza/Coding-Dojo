function challenge_1(array){

    var newArray=[]
    var tmp=0;

    for (var i=0; i< array.length;i++){

    if(array[i]>tmp){
        tmp=array[i]
        newArray.push(array[i])
    }
}
return(newArray)
}

console.log(challenge_1([0,1,4,8,5]));