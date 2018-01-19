package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Start a new project called "TurkeySandwich"
// Write a guessing game program.
// Your program should generate a random integer between 1 and 10000.
// Prompt the user to enter a guess.
// For each guess, output "HIGHER"
// if the guess is smaller than the random integer
// or "LOWER" if the user's guess is larger than the random integer.
// Also output the new range of eligible guesses.
// When the user guesses the random integer, output a message that says so
// and displays the number guesses it took to get to the right number.
// Additionally, it should show what numbers the user guessed along the way.
public class NumberGuessGame {

    public static void main(String[] args) {

        int iMin = 1;
        int i = 0;
        int iMax = 10000;
        int uNum = 0;
        int rNum = 0;
        int prevNum = 0;
        int saveRNum = 0;

        String sNum;
        String sMin;
        String sMax;
        String userAnswer;

        //List<int> sNumList = new ArrayList<>();

        System.out.println("Welcome to the Number Guessing Game");


        Boolean newGame = true;
        while (newGame) {
            iMin = 1;
            iMax = 10000;

        Boolean keepGuessing = true;
        while (keepGuessing) {

            // generate random integer between 1 and 10000
            Random rand = new Random();
            if (keepGuessing) {
                //sNumList.add(uNum);
                rNum = rand.nextInt((iMax - iMin) + 1) + iMin;
            } else {
                iMin = 1;
                iMax = 10000;
                rNum = rand.nextInt((iMax - iMin) + 1) + iMin;
//                For (i = 0; i < sNumList.length; i++) {
//                    sNumList.add(0);
//                }
            } // endif keepGuessing

            System.out.println("TESTING: rNum iMin iMax " + rNum + " " + iMin + " " + iMax);

            System.out.println("Please enter a number between " + iMin + " and " + iMax);
            Scanner sc1 = new Scanner(System.in);
            sNum = sc1.nextLine();
            uNum = Integer.parseInt(sNum);

        /* if guess = random indicate it to user
            display the number of attempts and show users the numbers guessed during attempts  */
            if (uNum == rNum) {
                System.out.println("You guessed the right number! Number: " + uNum);

                // else if guess < than random - output HIGHER
                // use the guessed number as the new min
            } else if (uNum < rNum) {
                System.out.println("HIGHER");
                iMin = uNum;
                System.out.println("iMin uNum" + iMin + " " + uNum);

                // else if guess > than random - output LOWER
                // use the guessed number as the new max
            } else {
                System.out.println("LOWER");
                iMax = uNum;
                System.out.println("iMin uNum" + iMin + " " + uNum);
            }


            // ask user if they want to continue
            System.out.println("Would you like to guess again?");
            Scanner sc2 = new Scanner(System.in);
            String UserAnswer = sc2.nextLine();
            if (UserAnswer.equalsIgnoreCase("yes") || UserAnswer.equalsIgnoreCase("y")) {
                keepGuessing = true;
            } else {
                keepGuessing = false;
            }

        } // end continue guessing

    System.out.println("Would you like to play a new game?");
    Scanner sc3 = new Scanner(System.in);
    String newGameYN = sc3.nextLine();
    if (newGameYN.equalsIgnoreCase("yes") || newGameYN.equalsIgnoreCase("y")) {
        newGame = true;
    } else {
        newGame = false;
    } // endif

    } // end of play a new game

    } // end of main
}  // end of class


