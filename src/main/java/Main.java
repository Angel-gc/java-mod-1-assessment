import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
   static int min = 0;
   static int max = 10;
   static int range = max - min + 1;
   static int systemNumber = (int)Math.floor(Math.random() * range) + min;
   static String winMessage = "Congrats you're a winner!";
   static String loseMessage = "Sorry you didn't win this time. Try again :/";
   static int difficulty;
   static int numberGuessed;
   static int difficultyInput;
   static String[] explanations = {"Easy: guess a number - program will tell you if it was higher or equal (you win) or lower (computer wins) than the program's number.", "Medium: guess a number - program will tell you if it was strictly higher (you win) or lower or equal (computer wins) than the program's number.", "Hard: guess a number - program will tell you if it was equal (you win) or not (you lose) to the program's number."};

    public static void main(String[] args) {
        // your code here
        try (Scanner scanner = new Scanner(System.in)){
            explainGame();
            difficulty = scanner.nextInt();
            explainMode(difficulty);
            numberGuessed = scanner.nextInt();
            chooseMode(difficulty, numberGuessed);
            
        } catch (InputMismatchException e) {
            //TODO: handle exception
            System.out.println("Your input must be a number. Try again.");
        }
    
    }
    public static void explainGame(){
        System.out.println("Hello we are going to play a comparision game!");
        System.out.println("\nPlease select a level of difficulty by entering the number associated with the difficulty...");
        System.out.println("\n0. Easy\n1. Medium\n2. Hard");
    }
    public static void explainMode(int num){
        System.out.println("Your Input:");
        System.out.println(num);
        for (int i = 0; i < explanations.length; i++) {
            if (num == i){
                System.out.println("\nHere are the rules..\n");
                System.out.println(explanations[i]);
                System.out.println(""); 
            } else {
                System.out.println("It doesn't seem like thats valid. Please try again.");
                break;
            };
          }
    }
    public static void chooseMode(int mode, int guess){
        if (mode == 0){
            easyMode(guess);
        }
        else if (mode == 1){
            mediumMode(guess);
        }
        else {
            hardMode(guess);
        }
    }

    public static void easyMode(int num){
        if (num >= systemNumber){
            System.out.println(winMessage);
        } else {
            System.out.println(loseMessage);
        }
    }
    public static void mediumMode(int num){
        if (num <= systemNumber){
            System.out.println(loseMessage);
        } else {
            System.out.println(winMessage);
        }
    }
    public static void hardMode(int num){
        if (num == systemNumber){
            System.out.println(winMessage);
        } else {
            System.out.println(loseMessage);
        }
    }
}
