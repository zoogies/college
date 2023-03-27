import java.util.Scanner;

public class Asgn_02 {
    
	public static Scanner cin = new Scanner(System.in);
    private static int cmdCount = 0;

    public static void main(String[] args) {
        int secret1, secret2, secret3;
        System.out.println("CPS 151 Assignment 2 (ComboLock) by Ryan Zmuda");
        System.out.println("Enter Lock creation data: 3 integers in correct range");
        secret1 = getIntInRange(0, 39);
        secret2 = getIntInRange(0, 39);
        secret3 = getIntInRange(0, 39);
        
        ComboLock L = new ComboLock(secret1, secret2, secret3);

        char choice = showMenuGetChoice();
        // process user's choice in a loop
        while (choice != 'Q') {
            applyChoice(choice, L);
            choice = showMenuGetChoice();
        } // end loop
        
        System.out.println("\nGoodbye");
    } // end main

    private static void applyChoice(char choice, ComboLock L) {
	// Write the code
    	if(choice == 'O') {
    		open(L);
    	}
    	else if(choice == 'L') {
    		turnLeft(L);
    	}
    	else if(choice == 'R') {
    		turnRight(L);
    	}
    	else if(choice == 'B') {
    		L.reset();
    	}
    	else {
    		System.out.println("Unrecognized Command");
    	}
    	L.showState();
    } // end method
    
    static void displayMenu() {
    	System.out.println("\nYour choices: turnLeft, turnRight, Open, Begin again, Quit");
        cmdCount++;
        System.out.print(cmdCount + ". Your choice (L/R/O/B/Q): ");
    } // end displayMenu

    private static char showMenuGetChoice() {
        displayMenu();
        return cin.next().toUpperCase().charAt(0);
    } // end method

    private static void turnLeft(ComboLock L) {
	// Write the code
    	L.turnLeft(getIntInRange(1,39));
    }  // end method

    private static void turnRight(ComboLock L) {
	// Write the code
    	L.turnRight(getIntInRange(1,39));
    }  // end method

    private static void open(ComboLock L) {
	// Write the code
    	if(L.open()) {
    		System.out.println("the lock is open");
    	}
    	else {
    		System.out.println("Sorry you failed to open the lock with the correct combination, reset the lock before you try again");
    	}
    }  // end method

    private static int getInt(String prompt) {
    	System.out.print(prompt);
        return cin.nextInt();
    } // end method

    // return range validated integer
    private static int getIntInRange(int lowerLimit, int upperLimit) {
        final String PROMPT = "Enter an integer in range [" +
                lowerLimit + ", " + upperLimit + "]: ";
        
        int number = getInt(PROMPT);
        while(number < lowerLimit || number > upperLimit) {
        	System.out.println(number + " is out of range");
            number = getInt(PROMPT);
        } // end loop
        
        return number;
    } // end method

} // end client class

// --------------------- class ComboLock
class ComboLock {
    // possible states for a ComboLock
    private static final int START = 1, FIRST = 2, SECOND = 3, THIRD = 4, 
            OPEN = 5, DEAD = 6;
    private static final String[] STATE_NAMES = {"", "START", "FIRST", "SECOND",
        "THIRD", "OPEN", "DEAD"};
    
    private int currentState; 
    
    private final int SECRET1, SECRET2, SECRET3;
    
    private int move1;
    private int move2;

    public ComboLock(int secret1, int secret2, int secret3) {
        SECRET1 = secret1;
        SECRET2 = secret2;
        SECRET3 = secret3;
        currentState = START;
    } // end constructor
    
    // this method is useful for debugging
    public void showState() {
    	System.out.println("The Lock state is " + STATE_NAMES[currentState]);
    } // end method
    
    public void reset() {
    	// Write the code
    	currentState = START;
    } // end reset
    
    public void turnLeft(int ticks) {
	// Write the code
        // turnLeft is only valid at state FIRST
        if(currentState == FIRST) {
        	int c = 40 - move1 + ticks;
        	if(c > 40) {
        		c-=40;
        	}
        	else if(c < 0) {
        		c+=40;
        	}
        	
        	if(c == SECRET2) {
        		currentState = SECOND;
        		move2 = ticks;
        	}
        	else {
        		currentState = DEAD;
        	}
        }
        else {
        	currentState = DEAD;
        }
    } // end turnLeft

    public void turnRight(int ticks) {
	// Write the code
        // turnRight is valid at state START or state SECOND
        if(currentState == START) {
        	if(40-ticks == SECRET1) {
        		currentState = FIRST;
        		move1 = ticks;
        	}
        	else {
        		currentState = DEAD;
        	}
        }
        else if(currentState == SECOND) {
        	int c = 40 - move1 + move2 - ticks;
        	if(c > 40) {
        		c-=40;
        	}
        	else if(c < 0) {
        		c+=40;
        	}
        	
        	if(c == SECRET3) {
        		currentState = THIRD;
        	}
        	else {
        		currentState = DEAD;
        	}
        }
        else {
        	currentState = DEAD;
        }
    } // end turnRight
    
    public boolean open() {
	// Write the code 
	// Change from THIRD, stay OPEN if already open
    	if(currentState == OPEN || currentState == THIRD) {
    		currentState = OPEN;
    		return true;
    	}
    	else {
    		currentState = DEAD;
    		return false;
    	}
	// otherwise move to DEAD
    } // end open

    // add any other private methods you may want

} // end class ComboLock