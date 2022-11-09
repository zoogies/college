// Customer_Balances.java

import java.io.PrintStream;
import java.util.Scanner;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Customer Balances (Java Arrays)
 * 
 * Name: Ryan Zmuda
 */

public class Customer_Balances
{
  static final Scanner KBD = new Scanner(System.in);
  static final PrintStream OUT = System.out;
  
  public static void main(String[] args)
  {
    // *** ADD LAB CODE HERE ***
	  Scanner kbd = new Scanner(System.in);
	  String[] a = {"Cathy","Ben","Jorge","Wanda","Freddie"};
	  for(String s: a) {
		  System.out.println(s);
	  }
	  Double[] b = {0.0,0.0,0.0,0.0,0.0};
	  
	  for(int i=0;i<a.length;i++) {
		  System.out.println("Enter the balance for "+a[i]);
		  b[i] = kbd.nextDouble();
	  }
	  
	  for(int i=0;i<a.length;i++) {
		  System.out.println(a[i] + " -> "+b[i]);
	  }
  } // end main method
} // end class Customer_Balances