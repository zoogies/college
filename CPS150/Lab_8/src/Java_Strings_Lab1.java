// Java_Strings_Lab1.java

import java.util.*;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Java Strings
 * 
 * Name: Ryan Zmuda
 * 
 */

public class Java_Strings_Lab1
{
  public static void main(String[] args)
  {
    String inputString = "The quick brown fox jumps over the lazy dog";
    String outputString = new String(); // empty String; can also use String outputString = "";
    
    /*
        Using only the String charAt method and concatenation (the + operator with Strings),
           complete the following sequence of commands that will extract characters
           from inputString to make outputString = "Tempus fugit".
        Remember that the charAt method is given a String index and produces the
           character at that index.  The index of the first character in any String
           is equal to 0, while the last index is equal to 1 less than the length of
           (number of characters in) the String.
        Also remember that the spaces in the String count as characters (the ' ' character).
     */
    
    outputString = outputString + inputString.charAt(0); // outputString is now "T"
    outputString += inputString.charAt(2);
    outputString += inputString.charAt(22);
    outputString += inputString.charAt(23);
    outputString += inputString.charAt(5);
    outputString += inputString.charAt(24);
    
    outputString += inputString.charAt(3);
    
    outputString += inputString.charAt(16);
    outputString += inputString.charAt(21);
    outputString += inputString.charAt(42);
    outputString += inputString.charAt(6);
    outputString += inputString.charAt(0);
    // add the rest of the statements to build the outputString
    
    System.out.println(outputString); // output the final outputString;
  } // end main
} // end class Java_Strings_Lab1