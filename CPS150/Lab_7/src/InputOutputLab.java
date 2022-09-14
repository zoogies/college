import java.util.Scanner;
/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Input/Output in Java
 * 
 * Name: Ryan Zmuda
 */

public class InputOutputLab
{
  public static void main(String[] args)
  {
    // 1. declare two integer variables
	  int one;
	  int two;
    // 2. declare and create a keyboard Scanner named 'scan'
	  Scanner sc = new Scanner(System.in);
    // 3. prompt the user to "Enter two integers separated by one or more spaces"
	  System.out.print("Enter two integers separated by one or more spaces: ");
    // 4. assign each integer variable to a user-input integer value
	  one = sc.nextInt();
	  two = sc.nextInt();
    // 5. output the larger (maximum) of the two variables (values) by calling the Math.max method
	  System.out.println("Larger: "+Math.max(one,two));
  } // end main method
} // end InputOutputLab class