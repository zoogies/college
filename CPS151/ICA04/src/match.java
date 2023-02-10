import java.util.Scanner;

public class match {
    // define a scanner attached to keyboard available to all functions
    final static Scanner cin = new Scanner(System.in);
    
    public static void main(String[] args) {
    	Boolean loop = true;
    	while(loop) {
    		System.out.print("CPS 151 ICA 04 String matching by Ryan Zmuda\n\n");
            
            System.out.print("Enter the text (one word) or QUIT: ");
            String hayStack = cin.next();
            if(hayStack.equals("QUIT")) {
            	loop = false;
            }
            else {
            	System.out.print("Enter the pattern (one word): ");
                String needle = cin.next();
                if (find(needle, hayStack))
                	System.out.println(needle + " was found in " + hayStack);
                else
                	System.out.println(needle + " was not found in " + hayStack);
                System.out.println();
            }
    	}
    } // end main

    private static boolean find(String needle, String hayStack) {
        int patLen = needle.length();
        int textLen = hayStack.length();
        // base case 1
        if (patLen > textLen) {
            return false;
        }
        else if (hayStack.startsWith(needle)) {   // base case 2 MODIFY!!
            return true;
        }
        else {
            return find(needle, hayStack.substring(1));
        }
    } // end method
}
