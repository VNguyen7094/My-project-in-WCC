
// Programmer:Destiney Allen-Suarez-Viet Trinh Nguyen-Sofia Lacki
// Source:DD/W3school
// Class:CS 141 f-f 1:30pm
// Purpose: A guessing game where the user tries to guess a randomly generated number.

import java.util.Random; //import random
import java.util.Scanner; // import scanner

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create new Scanner

        // created variables
        String yesNo;
        int Guesses;
        int totalGuesses = 0;
        int gameCounter = 1;
        int bestGuess = 100;

        // prompt
        instructions();
        System.out.println("Would you like to a game (yes/no): ");
        yesNo = input.next();

        // Checks if the user agreed to play a game
        while (yesNo.equalsIgnoreCase("yes")) {
            Guesses = playGame();
            totalGuesses += Guesses;
            gameCounter++;
        if (Guesses < bestGuess) {
            bestGuess = Guesses;
        }
        System.out.println("Would you like to a game (yes/no): ");
        yesNo = input.next();
        }
        // end of While loop

        totals(totalGuesses, gameCounter, bestGuess);
        System.out.println("I'm out of the while loop");

        input.close();
    }

    //intro to game
    public static void instructions() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }// end of intro to game

    //Play game once and return number of tires
    public static int playGame(){
        //define our objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int r = rand.nextInt(100) + 1;
        //created variables
        int playerGuess = 0; // Initialize playerGuess variable
        int numGuesses = 1;
        // promt
        System.out.println("I'm thinking of a number between 1 and 100");
        playerGuess = input.nextInt();
        while(playerGuess != r) {
            if (playerGuess > r){
            System.out.println("Too big, try again");
            playerGuess =input.nextInt();
            numGuesses++;
            }else { // too small
            System.out.println("Too small, try again");
            playerGuess = input.nextInt();
            numGuesses++;
            }// end of if/else
        }// end of while loop

        System.out.println("You got it in " + numGuesses + "tries");
        return numGuesses;
        }//end of playgame

        public static void totals(int totalGuesses, int gameCount, int bestGuess){
            System.out.println("total games = " + gameCount);
            System.out.println("total guesses = " + totalGuesses);
            System.out.println("guesses / game:" + (double) totalGuesses / gameCount);
            System.out.println("best game = " + bestGuess);

    }// end of totals
}// end of class