/*
 * ColorChooser.java
 */
 
import java.io.PrintStream;
import java.util.Scanner;

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Choosing Colors (Removing alternatives in if statements)
 *
 * @author Ryan Zmuda
 */

public class ColorChooser
{
   public static void main(String[] args)
   {
      PrintStream out = System.out;
      Scanner in = new Scanner(System.in);
      
      out.println("Enter an integer:");
      int x = in.nextInt();
      String color = "blue";
      if (x < 10)
      {
      	color = "red";
      }
      
      out.printf("You picked the color %s.\n", color);
   } // end main method
} // end class ColorChooser