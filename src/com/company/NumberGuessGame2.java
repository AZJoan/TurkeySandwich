package com.company;
//  Jan. 20 2018 - Expanded version of NumberGuessGame
// What was added in this version from previous version is noted below as >>ADDED
//---------------------------------------------------------------------------------------
// Write a guessing game program.
// Your program should generate a random integer between 1 and 10000.
// Prompt the user to enter a guess.
// For each guess, output "HIGHER"
// if the guess is smaller than the random integer
// or "LOWER" if the user's guess is larger than the random integer.
// Also output the new range of eligible guesses.
// When the user guesses the random integer, output a message that says so
// DONE >>ADDED - and displays the number guesses it took to get to the right number.
// >>ADDED - Additionally, it should show what numbers the user guessed along the way.
// DONE >>ADDED - Do not let user guess above max or below min


import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class NumberGuessGame2 {

        public static void main(String[] args) {

            ArrayList<Integer> ArrGuess = new ArrayList<>();

            int iMin = 1;
            int iMax = 10000;
            int uNum = 0;
            int rNum = 0;
            int prevNum = 0;
            int saveRNum = 0;
            int gCnt = 0;

            String sNum;
            String sMin;
            String sMax;
            String userAnswer;

            System.out.println("Welcome to the Number Guessing Game");

            Boolean newGame = true;
            while (newGame) {
                // initialize variables for start of new game
                iMin = 1;
                iMax = 10000;
                gCnt = 0;
                newGame = false;
                ArrGuess.clear();

                // When new game generate random integer between 1 and 10000
                Random rand = new Random();
                rNum = rand.nextInt((iMax - iMin) + 1) + iMin;
                // System.out.println("TESTING: new rNum generated " + rNum);
                saveRNum = rNum;

                Boolean keepGuessing = true;
                while (keepGuessing) {


                    // When not a new game used previous generated random number
                    if (!newGame) {
                        rNum = saveRNum;
                        // System.out.println("TESTING: rNum saveRNum " + rNum + " " + saveRNum);
                    }
                    // System.out.println("TESTING: rNum iMin iMax " + rNum + " " + iMin + " " + iMax);

                    boolean reTry = true;
                    while (reTry) {
                        reTry = false;
                        System.out.println("Please enter a number between " + iMin + " and " + iMax);
                        Scanner sc1 = new Scanner(System.in);
                        sNum = sc1.nextLine();
                        uNum = Integer.parseInt(sNum);
                        ArrGuess.add(uNum);  // save each guess
                        gCnt++;
                        if (uNum > iMax || uNum < iMin) {
                            reTry = true;
                            System.out.println("You must choose a number between " + iMin + " and " + iMax);
                        }
                    } // end while reTry

                    /* if guess = random indicate it to user
                        display the number of attempts and show users the numbers guessed during attempts  */
                    if (uNum == rNum) {
                        System.out.println("You guessed the right number! " + uNum + " It took you " + gCnt + " trys.");
                        System.out.println("Here is your list of guesses: ");
                        for (int i = 0; i < ArrGuess.size(); i++) {
                            System.out.println(ArrGuess.get(i));
                        }
                        keepGuessing = false;
                    } else {

                        // if guess < than random - output HIGHER - use the guessed number as the new min
                        if (uNum < rNum) {
                            System.out.println("GUESS HIGHER NEXT TIME!");
                            iMin = uNum;
                            // System.out.println("TESTING: iMin uNum" + iMin + " " + uNum);

                        // else if guess > than random - output LOWER - use the guessed number as the new max
                        } else {
                            System.out.println("GUESS LOWER NEXT TIME!");
                            iMax = uNum;
                            // System.out.println("TESTING: iMin uNum" + iMin + " " + uNum);
                        }
                        // ask user if they want to continue guessing
                        System.out.println("Would you like to guess again? Y/Yes or N/No");
                        Scanner sc2 = new Scanner(System.in);
                        String UserAnswer = sc2.nextLine();
                        if (UserAnswer.equalsIgnoreCase("yes") || UserAnswer.equalsIgnoreCase("y")) {
                            keepGuessing = true;
                        } else {
                            keepGuessing = false;
                        }

                    } // end if they guessed right
              } // end while continue guessing

                System.out.println("Would you like to play a new game?");
                Scanner sc3 = new Scanner(System.in);
                String newGameYN = sc3.nextLine();
                if (newGameYN.equalsIgnoreCase("yes") || newGameYN.equalsIgnoreCase("y")) {
                    newGame = true;
                } else {
                    newGame = false;
                }

            } // end while play a new game
       } // end of main class
}  // end of object class

