// Course: CPS 151
// Semester: 2023 Spring
// Name: Ryan Zmuda
// Section: 3
// Assignment: 1
// Purpose: Program to add and remove dynamic array elements
// Date completed: jan 10 2023
package assignment_1;

import java.util.Scanner;

public class assignment_1 {
	 	final static Scanner cin = new Scanner(System.in);
	    static int currentSize; // number of values actually in the intList
	    static int[] intList;   // reference to the partially filled array storage

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        System.out.println("CPS 151 ICA 1 by Ryan Zmuda");
	        setup();
	        printList(intList, "\nOriginal List");
	        checkDeletion();
	        checkInsertion();
	        printList(intList, "\nFinal List");
	        System.out.println("\nGoodbye");
	    } // end main

	    private static void checkDeletion() {
	        // Checking deletion
	        int position = getInt("\nPosition to delete from: ");

	        // check validity of position
	        if (position<=currentSize) {
	            shiftUp(position);
	            currentSize--;
	            printList(intList, "\nList after deletion");
	        } else {
	        	System.out.println("Invalid delete position, no changes made");
	        } // end if
	    } // end method

	    private static void checkInsertion() {
	        // Checking insertion
	        int value = getInt("\nValue to insert: ");
	        int position = getInt("At what position? ");
	        
	        // check validity of position
	        if (position<=currentSize) { //TODO double check
	            shiftDown(position);
	            intList[position] = value;
	            currentSize++;
	            printList(intList, "\nList after insertion");
	        } else {
	        	System.out.println("Invalid insert position, no changes made");
	        } // end if
	    } // end method

	    // fills array with increasing values
	    private static void fillArrayInc(final int startValue, final int howMany) {
	        // Validity check 
	        if (howMany < 1 || howMany > intList.length) {
	            terminate("fillArrayInc: illegal argument, howMany = " + howMany);
	        }

	        for (int k = 0; k < howMany; k++) {
	            intList[k] = startValue + k;
	        }
	        currentSize = howMany;
	    } //end setSequenced

	    // prints partially filled array with a legend
	    private static void printList(final int[] arr, final String legend) {
	    	System.out.println(legend);
	        for (int k = 0; k < currentSize; k++) {
	        	System.out.print(" " + arr[k]);
	        }
	        System.out.println();
	    } // end printList

	    // move items from pos+1:currentSize-1 one position up (lower subscripts)
	    private static void shiftUp(int pos) { // moving right elements left
	        // Write the code
	    	for(int i=pos; i<currentSize-1; i++) {
	    		int next =intList[i+1];
	    		intList[i] = next;
	    	}
	    } // end shiftUp

	    // move items from pos:currentSize-1 one position down (higher subscripts)
	    private static void shiftDown(int pos) { //moving left elements right
	    	// [1,2,3..] -> [0,1,2,3..]
	        // Write the code
	    	for(int i=currentSize; i>pos; i--) {
	    		int previous = intList[i-1];
	    		intList[i] = previous;
	    	}
	    	
	    } // end shiftDown

	    private static void setup() {
	        int maxSize, initSize;
	        maxSize = getInt("Enter the maximum size: ");
	        intList = new int[maxSize];
	        initSize = getInt("Enter the starting size: ");
	        if (initSize > maxSize) {
	            terminate("starting size cannot be greater than maximum size");
	        }
	        fillArrayInc(100, initSize);
	    } // end method

	    private static int getInt(String prompt) {
	    	System.out.print(prompt);
	        return cin.nextInt();
	    } // end method

	    private static void terminate(String message) {
	    	System.out.println("Error: " + message);
	    	System.exit(0);
	    } // end terminate
}
