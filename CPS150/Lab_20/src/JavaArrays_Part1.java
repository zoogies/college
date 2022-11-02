// JavaArrays_Part1.java

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Intro to Java Arrays (Part 1)
 * 
 * Name:Ryan Zmuda
 */

public class JavaArrays_Part1
{
  public static void main(String[] args)
  {
	  Double[] x = new Double[20];
	  Random r = new Random();
  	// ADD LAB CODE HERE
	  for(int i=0;i<20;i++) {
		  x[i] = r.nextDouble() * 100;
	  }
	  
	  System.out.println(x.length);
	  System.out.println(x[0]);
	  System.out.println(x[x.length - 1]);
	  System.out.println(x[x.length -1]);
	  for(Double d: x) {
		  System.out.println(d);
	  }
	  for(int i=0;i<20;i++) {
		  System.out.println(i + 1+" - "+x[i]);
	  }
	  for(int i=19;i>-1;i--) {
		  System.out.println(i + 1+" - "+x[i]);
	  }
  } // end main method
} // end class JavaArrays_Part1