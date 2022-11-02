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
public class rpsls
{
    // global named constant for random number generator
    public static Random gen = new Random();

    // global named constants for game choices
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static final int LIZARD = 4;
    public static final int SPOCK = 5;
    
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

        int player1 = 0, player2;

        // get player 1 input as 1 (rock), 2 (paper or 3 (scissors)
        output.print("Welcome to the game of Rock Paper Scissors Lizard Spock");
        output.print("Here are the rules:\n"
        		+ "    Scissors cuts Paper\n"
        		+ "    Paper covers Rock\n"
        		+ "    Rock crushes Lizard\n"
        		+ "    Lizard poisons Spock\n"
        		+ "    Spock smashes Scissors\n"
        		+ "    Scissors decapitates Lizard\n"
        		+ "    Lizard eats Paper\n"
        		+ "    Paper disproves Spock\n"
        		+ "    Spock vaporizes Rock\n"
        		+ "    (and as it always has) Rock crushes scissors");
        output.println("\nReady?  Then let's begin!");
        
        Boolean playing = true;
        while(playing) {
        	
        	// whole game loop here
        	
        	output.println("Player 1, enter your choice ( rock, paper, scissors, lizard, spock ): ");
        	String choice = scan.nextLine();
        	
        	if(!(choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("scissors") || choice.equalsIgnoreCase("paper") || choice.equalsIgnoreCase("lizard") || choice.equalsIgnoreCase("spock"))) {
        		output.println("Invalid choice. Try again.");
        	}
        	else {
      
        		if(choice.equalsIgnoreCase("rock")) {
        			player1 = ROCK;
        		}else if(choice.equalsIgnoreCase("paper")) {
        			player1 = PAPER;
        		}else if(choice.equalsIgnoreCase("scissors")) {
        			player1 = SCISSORS;
        		}else if(choice.equalsIgnoreCase("lizard")) {
        			player1 = LIZARD;
        		}else if(choice.equalsIgnoreCase("spocks")) {
        			player1 = SPOCK;
        		}
        		
        		
        		// echo human player's choice
                output.print(" You chose ");
                if (player1 == ROCK) {       System.out.println("rock"); }
                else if (player1 == PAPER) { System.out.println("paper"); }
                else if (player1 == SCISSORS) {                       System.out.println("scissors"); }
                else if (player1 == LIZARD) {                       System.out.println("lizard"); }
        		else {                       System.out.println("spock"); }
        	
        	
                // now computer picks one randomly

                output.println("Now I choose one ...");
                player2 = (int)Math.floor(Math.random()*(5-1+1)+1);
               
                System.out.print(" I choose ");
               
                // RPS Lab Part 3
                //
                // *** Add code here to output the computer's choice
                //     as "rock", "paper" or "scissors"
                if (player2 == ROCK) {       System.out.println("rock"); }
                else if (player2 == PAPER) { System.out.println("paper"); }
                else if (player2 == SCISSORS){                       System.out.println("scissors"); }
                else if (player2 == LIZARD){                       System.out.println("lizard"); }
        		else {                       System.out.println("spock"); }
        	
        	
                
                int outcome;
                
                if(player1 == ROCK) {
                	outcome = rockChoice(player2);
                }
                else if(player1 == PAPER){
                	outcome = paperChoice(player2);
                }
                else if(player1 == SCISSORS){
                	outcome = scissorsChoice(player2);
                }
                else if(player1 == LIZARD) {
                	outcome = lizardChoice(player2);
                }
                else {
                	outcome = spockChoice(player2);
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
        	}

        	output.print("Do you want to play again? yes/no\n");
        	String cont = scan.nextLine();
        	if(cont.equals("no")) {
        		break;
        	}
        }
        
    } // end main
    
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
    	else if(a == LIZARD) {
    		return PLAYER1_WINS;
    	}
    	else if(a == SPOCK) {
    		return PLAYER2_WINS;
    	}
    	else {
    		return ERROR;
    	}
    }
    
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
    	else if(a == LIZARD) {
    		return PLAYER2_WINS;
    	}
    	else if(a == SPOCK) {
    		return PLAYER2_WINS;
    	}
    	else {
    		return ERROR;
    	}
    }

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
    	else if(a == LIZARD) {
    		return PLAYER1_WINS;
    	}
    	else if(a == SPOCK) {
    		return PLAYER2_WINS;
    	}
    	else {
    		return ERROR;
    	}
    }
    
    public static int lizardChoice(int a) {
    	if(a == ROCK) {
    		return PLAYER2_WINS;
    	}
    	else if (a == PAPER) {
    		return PLAYER1_WINS;
    	}
    	else if(a == SCISSORS) {
    		return PLAYER2_WINS;
    	}
    	else if(a == LIZARD) {
    		return DRAW;
    	}
    	else if(a == SPOCK) {
    		return PLAYER1_WINS;
    	}
    	else {
    		return ERROR;
    	}
    }
    
    public static int spockChoice(int a) {
    	if(a == ROCK) {
    		return PLAYER1_WINS;
    	}
    	else if (a == PAPER) {
    		return PLAYER2_WINS;
    	}
    	else if(a == SCISSORS) {
    		return PLAYER1_WINS;
    	}
    	else if(a == LIZARD) {
    		return PLAYER2_WINS;
    	}
    	else if(a == SPOCK) {
    		return DRAW;
    	}
    	else {
    		return ERROR;
    	}
    }
} // end class CPS150_RPSLab