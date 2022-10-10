import java.util.Scanner;

/*
 * CirclesLab.java
 */

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Overlapping circles
 *
 * name: Ryan Zmuda
 */

public class CirclesLab
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.print("Input the radius of the first circle: ");
      double radius1 = in.nextDouble(); 
      double xcenter1 = 0;
      double ycenter1 = 0;
      System.out.print("Input the radius of the second circle: ");
      double radius2 = in.nextDouble(); 
      double xcenter2 = 40;
      double ycenter2 = 0;
      
      // Your work goes here:
      // if the two radius added are more than the distance between the centers
      double distance = xcenter2 - xcenter1;
      if(radius1 + radius2 < distance) {
    	  System.out.println("Disjoint");
      }
      else {
    	  if(radius2 > distance || radius1 > distance) {
    		  System.out.println("Mutually Contained");
    	  }
    	  else {
    		  System.out.println("Overlapping");
    	  }
      }
   } // end main method
} // end class CirclesLab