import java.util.Arrays;
import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();

        // ************** Implement the getTenRolls method *************
        System.out.println("\n ************** Implement the getTenRolls method *************");
        // for (int i=0; i<=10;i++){
        //     ArrayList <Integer> randomRolls = generator.getTenRolls();
        //     System.out.println(randomRolls);
        // }

        // *************** Implement the getRandomLetter method **************************
        System.out.println("\n ************** Implement the getRandomLetter method **************************");
        System.out.println("\n The Random Letter is :  "+generator.getRandomLetter());
        
        // *************** Implement the generatePassword method *************************
        System.out.println("\n *************** Implement the generatePassword method *************************");
        System.out.println("the password generated is : " + generator.generatePassword() );

        // *************** Implement the generateNewPassword method *************************
        System.out.println("\n *************** Implement the generatePassword method *************************");
        System.out.println("the password generated is : " + generator.generatePassword(10) );
    
        // *************** SENSEI BONUS: Implement the shuffle method ***********************
        System.out.println("\n *************** SENSEI BONUS: Implement the shuffle method ***********************");
        generator.shuffleArray();
    }
}
