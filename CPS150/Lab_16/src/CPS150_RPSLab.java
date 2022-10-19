/*
 * CPS150_RPSLab.java
 */

import java.io.*;
import java.util.*;

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Rock, Paper, Scissors
 *
 * @author Ryan Zmuda
 */
public class CPS150_RPSLab
{
    // global named constant for random number generator
    public static Random gen = new Random();

    // global named constants for game choices
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    
    // global names constants for game outcomes
    public static final int PLAYER1_WINS = 11;
    public static final int PLAYER2_WINS = 12;
    public static final int DRAW = 3;
    
    // global named constant for error condition
    public static final int ERROR = -1;

    /**
     * 1. Get human player's choice
     * 2. Get computer player's (random) choice
     * 3. Check human player's choice
     * 4. Check computer player's choice
     * 5. Announce winner
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        PrintStream output = System.out;

        int player1, player2;

        // get player 1 input as 1 (rock), 2 (paper or 3 (scissors)
        output.print("Choose 1 (rock), 2 (paper), or 3 (scissors): ");
        player1 = scan.nextInt();

        // RPS Lab Part 1
        //
        // *** Add code here to validate that player1 has entered
        //     an integer between 1 and 3
        //     otherwise, ABORT the program
        if(player1 <=3 && player1>=1) {
        	
        }
        else {
        	System.out.println("Invalid input");
        	return;
        }
        
        
        
        // echo human player's choice
        output.print(" You chose ");
        if (player1 == ROCK) {       System.out.println("rock"); }
        else if (player1 == PAPER) { System.out.println("paper"); }
        else {                       System.out.println("scissors"); }

        // now computer picks one randomly

        output.println("Now I choose one ...");

        /*
            RPS Lab Part 2
            
            *** Add code to and un-comment the following line so that
                player2 is set to a random integer between 1 and 3,
                using the gen Random object, ALREADY DECLARED AS
                A GLOBAL VARIABLE:
        */

        player2 = (int)Math.floor(Math.random()*(3-1+1)+1);
       
        System.out.print(" I choose ");
       
        // RPS Lab Part 3
        //
        // *** Add code here to output the computer's choice
        //     as "rock", "paper" or "scissors"
        if (player2 == ROCK) {       System.out.println("rock"); }
        else if (player2 == PAPER) { System.out.println("paper"); }
        else {                       System.out.println("scissors"); }
        

        // RPS Lab Part 4
        //
        // *** Add code below to compare player input against
        //     computer's choice and output results:
        //
        //     if human player chose ROCK:
        //       call rockChoice method with computer choice
        //       output the game's outcome based on result of call to rockChoice
        //     otherwise, if human player chose PAPER:
        //       call paperChoice method with computer choice
        //       output the game's outcome based on result of call to paperChoice
        //     otherwise, if human player chose SCISSORS:
        //       call scissorsChoice method with computer choice
        //       output the game's outcome based on result of call to scissorsChoice
        int outcome;
        
        if(player1 == ROCK) {
        	outcome = rockChoice(player2);
        }
        else if(player1 == PAPER){
        	outcome = paperChoice(player2);
        }
        else {
        	outcome = scissorsChoice(player2);
        }
        if(outcome == DRAW) {
    		System.out.println("Draw!");
    	}
    	else if(outcome == PLAYER1_WINS) {
    		System.out.println("Player 1 wins!");
    	}
		else if(outcome == PLAYER2_WINS) {
			System.out.println("Player 2 wins!");
		}
		else {
			System.out.println("Error!");
		}
        
    } // end main
    
    /**
     * RPS Lab Part 5
     * 
     * rockChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER or SCISSORS),
     *   assuming the human player has chosen ROCK
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     * ex1: rockChoice(ROCK) -> DRAW
     * ex2: rockChoice(PAPER) -> PLAYER2_WINS
     * ex3: rockChoice(SCISSORS) -> PLAYER1_WINS
     * ex4: rockChoice(0) -> ERROR
     * ex5: rockChoice(-1) -> ERROR
     * ex6: rockChoice(4) -> ERROR
     * 
     * *** ADD METHOD CODE HERE ***
     */
    public static int rockChoice(int a) {
    	if(a == ROCK) {
    		return DRAW;
    	}
    	else if (a == PAPER) {
    		return PLAYER2_WINS;
    	}
    	else if(a == SCISSORS) {
    		return PLAYER1_WINS;
    	}
    	else {
    		return ERROR;
    	}
    }
    
    /**
     * RPS Lab Part 6
     * 
     * paperChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER or SCISSORS),
     *   assuming the human player has chosen PAPER
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     * ex1: paperChoice(ROCK) -> PLAYER1_WINS
     * ex2: paperChoice(PAPER) -> DRAW
     * ex3: paperChoice(SCISSORS) -> PLAYER2_WINS
     * ex4: paperChoice(0) -> ERROR
     * ex5: paperChoice(-1) -> ERROR
     * ex6: paperChoice(4) -> ERROR
     * 
     * *** ADD METHOD CODE HERE ***
     */
    public static int paperChoice(int a) {
    	if(a == ROCK) {
    		return PLAYER1_WINS;
    	}
    	else if (a == PAPER) {
    		return DRAW;
    	}
    	else if(a == SCISSORS) {
    		return PLAYER2_WINS;
    	}
    	else {
    		return ERROR;
    	}
    }
    
    /**
     * RPS Lab Part 7
     * 
     * scissorsChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER or SCISSORS),
     *   assuming the human player has chosen SCISSORS
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     * ex1: scissorsChoice(ROCK) -> PLAYER2_WINS
     * ex2: scissorsChoice(PAPER) -> PLAYER1_WINS
     * ex3: scissorsChoice(SCISSORS) -> DRAW
     * ex4: scissorsChoice(0) -> ERROR
     * ex5: scissorsChoice(-1) -> ERROR
     * ex6: scissorsChoice(4) -> ERROR
     * 
     * *** ADD METHOD CODE HERE ***
     */
    public static int scissorsChoice(int a) {
    	if(a == ROCK) {
    		return PLAYER2_WINS;
    	}
    	else if (a == PAPER) {
    		return PLAYER1_WINS;
    	}
    	else if(a == SCISSORS) {
    		return DRAW;
    	}
    	else {
    		return ERROR;
    	}
    }
} // end class CPS150_RPSLab