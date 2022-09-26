// MethodAnalysis_Lab1.java

import java.util.*;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: What's Wrong With My Method?
 * 
 * Name: Ryan Zmuda
 * 
 */

public class MethodAnalysis_Lab1
{
   public static void main(String[] args)
   {
      int x = 2;
      int y = 3;
      int z = 5;
      System.out.println("x:  " + x + " y:  " + y + " Sum:  " + sum(x,y));
   } // end main method
        
   /**
      Computes the sum of two arguments.
      @param a an int operand to be added
      @param b another int operand
      @return the sum of a and b
   */
   public static int sum(int a, int b)
   {
	  System.out.println("Finished adding...");
      return a + b;
   } // end sum method
} // end MethodAnalysis_Lab1