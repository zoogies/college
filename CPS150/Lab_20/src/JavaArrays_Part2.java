// JavaArrays_Part2.java

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;
/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Intro to Java Arrays (Part 2)
 * 
 * Name: Ryan Zmuda
 */

public class JavaArrays_Part2
{
  public static void main(String[] args)
  {
  	// ADD LAB CODE HERE
	  Double[] x = new Double[20];
	  Random r = new Random();
  	// ADD LAB CODE HERE
	  for(int i=0;i<20;i++) {
		  x[i] = r.nextDouble() * 100;
	  }
	  Double total = 0.0;
	  for(Double d: x) {
		  total += d;
	  }
	  System.out.println("total: "+total);
	  Double min = 10000000.0;
	  Double max = 0.0;
	  for(Double d: x) {
		  if(d<min) {
			  min = d;
		  }
		  if(d>max) {
			  max = d;
		  }
	  }
	  System.out.println("min: "+min+" max: "+max);
	  min = 10000000.0;
	  int minin = 0;
	  max = 0.0;
	  int maxin = 0;
	  for(int i=0;i<20;i++) {
		  if(x[i]<min) {
			  min = x[i];
			  minin = i;
		  }
		  if(x[i]>max) {
			  max = x[i];
			  maxin = i;
		  }
	  }
	  System.out.println("min (index "+minin+"): "+min+" max (index "+maxin+"): "+max);
	  
  } // end main method
} // end class JavaArrays_Part2