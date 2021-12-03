package org.example.testapp;

import java.util.Random;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {

        boolean startGame = false;
        boolean continueLooping = true;
        int numberOfGuesses = 0;
        String input = "";

        System.out.println("Guessing game!");
        System.out.print("Should we start the game? (y/n): ");

        Scanner scanner = new Scanner(System.in);

        do {
            input = scanner.next();
            //System.out.println("Guess: [" + input + "]");
            if(input.equals("y")){
                startGame = true;
                continueLooping = false;
            } else if (input.equals("n")) {
                continueLooping = false;
            } else {
                System.out.println("Only enter [y] or [n].");
                System.out.print("Try again: ");
            }
        } while (continueLooping); // stay in the loop until a user enters a correct value

        if(startGame){
            continueLooping = true; // Reset the variable
            Random random = new Random();
            int randomNumber = random.nextInt(20) + 1; // generate random number
            System.out.println("Random number ( 0 - 20 ) has been generated!");
            System.out.println("Try to guess it :) \n");
            do {
                numberOfGuesses++;
                System.out.print("Enter a guess: ");
                input = scanner.next(); // Get the string input
                int temp_int = Integer.parseInt(input); // Convert it to int
                if (temp_int == randomNumber) {
                    System.out.println("\nYou guessed right!!!");
                    System.out.println("The game has ended!");
                    System.out.println("You guessed [" + numberOfGuesses + "] times.");
                    break; // Break out of the loop on game end
                } else if (temp_int < randomNumber) {
                    System.out.println("Try a higher guess."); // Suggest a higher guess
                } else if (temp_int > randomNumber) {
                    System.out.println("Try a lower guess."); // Suggest a lower guess
                }
                if (numberOfGuesses == 5) {
                    System.out.println("You guessed too many times.");
                    System.out.println("Game has been terminated!");
                    System.out.println("The number was [" + randomNumber + "].");
                    continueLooping = false; // End game on too many guesses
                }
                System.out.println("You guessed [" + numberOfGuesses + "] times.");
            } while(continueLooping);
        } else {
            System.out.println("Game has been canceled!");
        }
        // End of game
    }
}
