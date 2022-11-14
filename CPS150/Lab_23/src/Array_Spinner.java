// Array_Spinner.java

import java.io.*;
import java.util.*;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Rotating Java Arrays
 * 
 * Name: Ryan Zmuda
 */

public class Array_Spinner
{
  // Complete the rotate method implementation here:
  public static double[] rotate(double[] values, int rotation)
  {
	  double n[] = new double[values.length];
	  for(int i=0;i<values.length;i++) {
		  if(i>rotation) {
			  n[i - rotation -1] = values[i];
		  }
		  if(i<=rotation) {
			  n[(values.length - rotation) + i -1] = values[i];
		  }
	  }
	  return n;
  } // end rotate method
  
  public static void main(String[] args)
  {
    double[] x = {8, 4, 5, 21, 7, 9, 18, 2, 100};
    
    System.out.println("Before rotation:  ==============================");
    
    for (int i = 0; i < x.length; i++)
    {
      System.out.println("x[" + i + "]:  " + x[i]);
    }
    
    x = rotate(x, 3);
    
    System.out.println("\nAfter rotation:  ==============================");   
       
    for (int i = 0; i < x.length; i++)
    {
      System.out.println("x[" + i + "]:  " + x[i]);
    }
  } // end main method
  
} // end class Array_Spinner