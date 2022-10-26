/*
 * CPS 150
 * Algorithms & Programming I
 */

import java.io.*;
import java.util.*;

/**
 * Lab Project: The Babylonian Algorithm
 * 
 * @author Ryan Zmuda
 */
public class CPS150_BabylonianLab
{
    // *** global variables for input and output objects ***
    
    static Scanner kbd = new Scanner( System.in );
    static PrintStream out = System.out;
    static PrintStream err = System.err;
    
    /**
     * sqrt(double) -> double
     * 
     * method implements the Babylonian Algorithm to estimate
     *   the square root of the given number:
     * 
     * 1. Make a guess at the answer (you can pick S/2 as your initial guess).
     * 2. Compute r = S / guess.
     * 3. Set new guess = (guess + r) / 2
     * 4. Go back to step 2 until the last two guess values are within 1% of each other
     * 
     * ex1: sqrt(4.0) -> 2.000000
     * ex2: sqrt(7.5) -> 2.738615
     * ex3: sqrt(9.0) -> 3.000015
     * 
     * *** TO DO: ADD sqrt METHOD DEFINITION/IMPLEMENTATION IMMEDIATELY BELOW THIS LINE ****/
public static double sqrt(double S) {
	double guess = S;
    double r = 1;

    while (guess - r > .01) {
        guess = (guess + r) / 2;
        r = S / guess;
    }
    return guess;
}
    
    /* *** YOU ARE NOT ALLOWED TO MODIFY ANY CODE BELOW THIS LINE. *** */
    /* *** DOING SO WILL RESULT IN A GRADE OF 0 FOR THIS LAB PROJECT. *** */
    
    /**
     * getInput(double) -> double
     * 
     * method repeatedly prompts and gets user input until an double value
     *   is entered that is at least as large as the given minimum value
     * method returns the first input that meets this requirement
     * 
     * method prompts user with message:
     *      "Enter a number greater or equal to m: ", where m is the
     *          given minimum (parameter) value
     * method rejects all non-double input with error message:
     *      "Invalid data type (not numeric)"
     * method rejects all invalid input (i.e., less than m) with error message:
     *      "Invalid value (too small)"
     * 
     * ex: getInput(1.0) -> 15.000000
     */
    public static double getInput(double min)
    {
      double result = 0;
      boolean done = false;
      
      while (!done)
      {
        out.printf("Enter a number greater or equal to %.1f: ", min);
        if (kbd.hasNextDouble())
        {
          result = kbd.nextDouble();
          if (result >= min)
          {
            done = true;
          }
          else
          {
            out.println("Invalid value (too small)");
          } // end inner if/else
        }
        else
        {
          out.println("Invalid data type (not numeric)");
          kbd.nextLine(); // flush Scanner data
        } // end outer if/else
      } // end while
      
      return result;
    } // end getInput
    
    /**
     * CPS150_Lab20 : double ; double
     * 
     * program is given a positive number S as user input
     * program uses the Babylonian Algorithm to estimate
     *  and output the square root of S
     * 
     * ex1: user inputs 4.0; program outputs 2.00
     * ex2: user inputs 7.5; program outputs 2.74
     * ex3: user inputs 9.0; program outputs 3.00
     */
    public static void main(String[] args)
    {
        double S; // input var
        double result; // output var (square root of S)
        
        // 1. get a positive number S from the user
        S = getInput(1);
        
        // 2. estimate the square root of S
        result = sqrt(S);
        
        // 3. output the square root of S
        out.printf("\tThe square root of %.1f is %.1f\n", S, result);
    } // end main method
    
} // end CPS150_BabylonianLab