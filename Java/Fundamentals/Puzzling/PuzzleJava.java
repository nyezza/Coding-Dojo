import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {

    // ************** Implement the getTenRolls method *************
    public ArrayList <Integer> getTenRolls(){
        ArrayList <Integer> numArray = new ArrayList<Integer>();
        Random rnd = new Random();
        
            int m= rnd.nextInt(20);
            numArray.add(m);
            return numArray;
    }

    // *************** Implement the getRandomLetter method **************************
    public String getRandomLetter(){
        String[] alphArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random rnd = new Random();
        int index=rnd.nextInt(26);
        String Letter = alphArray[index];
        return Letter;
    }

    public String generatePassword(){
        
        String passChain="";
        for (int i=0; i<8; i++){
            passChain= passChain + getRandomLetter();
        }
        return passChain;
    }

        // *************** Implement the generateNewPassword method *************************
        public String generatePassword(int length){
            System.out.println("this password length is :"+length);
            String passChain="";
            for (int i=0; i<length-1; i++){
                passChain= passChain + getRandomLetter();
            }
            return passChain;
        }

        // *************** SENSEI BONUS: Implement the shuffle method ***********************
        void shuffleArray(){
            String[] shuffle={"nedhir","nouha","nidhal"};
            String[] temp;
            temp= new String[shuffle.length];
            Random ran=new Random();
            for (int i=0; i<=shuffle.length-1;i++){
                int t = ran.nextInt(shuffle.length);
                temp[i]=shuffle[t];
                System.out.println(temp[i]);
            }
        }
}
