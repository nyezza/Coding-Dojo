function challenge_2(word){

    var left = 0;
    var right = word.length-1;

    while(left<right){
        if(word.charAt(left) != word.charAt(right)){
            
            return false
            
        }

        left +=1;
        right -=1;
        
        
    }
    return true
}

console.log(challenge_2('madsm'));