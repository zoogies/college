// Peevish_Postman.java

import java.util.*;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: The Peevish Postman Problem (Java Boolean Arrays)
 * 
 * Name: Ryan Zmuda
 */

public class Peevish_Postman
{
  public static void main(String[] args)
  {
    boolean[] doors;
    final int NODOORS = 101;    // We will not use door[0]
    final boolean OPEN = true;
    final boolean CLOSED = false;
    // Initialize the doors
    doors = new boolean[NODOORS];
    for (int i = 0;  i < NODOORS; i++)
    {
      doors[i] = CLOSED;
    }
    // Print the initial state of each door (only doors 1-100)
    for (int i = 1; i < doors.length; i++)
    {
      System.out.print("Door " + i + " is ");
      if (doors[i]) { System.out.println("open."); }
      else { System.out.println("closed."); }
    }
    
    // ADD YOUR CODE BETWEEN THIS LINE ...
    for(int i=1;i<doors.length;i++) {
    	for(int b=i;b<doors.length;b+=i) {
    		if(doors[i] == OPEN) {
        		doors[i] = CLOSED;
        	}
        	else {
        		doors[i] = OPEN;	
        	}	
    	}
    }
    // ... AND THIS LINE
    
    // Print the final state of each door (only doors 1-100)
    for (int i = 1; i < doors.length; i++)
    {
      System.out.print("Door " + i + " is ");
      if (doors[i]) { System.out.println("open."); }
      else { System.out.println("closed."); }
    }
  } // end main method
} // end class Peevish_Postman