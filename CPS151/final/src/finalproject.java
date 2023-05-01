import java.util.NoSuchElementException;
import java.util.Scanner;

public class finalproject {

    private static SLND<String> guests, victuals;
    static int cmdCount = 0;    // command counter
    private static final Scanner cin = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("CPS 151 Final Project by Ryan Zmuda");
        tellPurpose();
        guests = new SLND_LinkedList<>("Guest List");
        victuals = new SLND_LinkedList<>("Food and Beverage List");
        mainMenu();
        System.out.println("\nFinal lists:\n");
        System.out.println(guests);
        System.out.println(victuals);
        System.out.println("\nCPS 151 Final Project complete");
    } // end main

    private static void mainMenu() {
        char choice = mainMenuGetChoice();

        while (choice != 'Q') {
	    // TODO: call "maintain" with appropriate argument
	    // or say that the choice is invalid
        	if(choice == 'F') {
            	maintain(victuals);
            }
            else if(choice == 'G') {
            	maintain(guests);
            }
            else {
            	System.out.println("Invalid Choice");
            }
            choice = mainMenuGetChoice();
            
        } // end loop
    } // end mainMenu

    private static char mainMenuGetChoice() {
        cmdCount++;
        System.out.println("\nMaintain: F)ood and beverage list, or G)uest list, " + 
                "or Q)uit the program");
        System.out.print(cmdCount + ". Your choice (F/G/Q): ");
        return cin.nextLine().toUpperCase().charAt(0);
    } // end method

    private static void maintain(SLND<String> theList) {
    	System.out.println("\nWorking with " + theList.name);
        char choice = subMenuGetChoice();

        while (choice != 'Q') {
	  // begin try block
	    // TODO: call appropriate client side method to handle user's choice
	    // or say that the choice is invalid
	  // end try block
          // catch block to catch the exception
	     // print the message from the exception
	  // end catch block
        	try {
        		if(choice == 'A') {
            		add(theList);
            	}
            	else if(choice == 'F') {
            		find(theList);
            	}
            	else if(choice == 'P') {
            		
            	}
            	else if(choice == 'R') {
            		remove(theList);
            	}
            	else {
            		System.out.println("Invalid Choice");
            	}
        	}
        	catch(Exception e){
        		System.out.println("An Error Occurred -> "+e);
        	}
        	

            choice = subMenuGetChoice();
        } // end loop

        System.out.println("Ended working with " + theList.name);
    } // end method

    private static char subMenuGetChoice() {
        cmdCount++;
        System.out.println("\nChoices: A)dd, F)ind, P)rint, R)emove, Q)uit");
        System.out.print(cmdCount + ". Your choice (A/F/P/R/Q): ");
        return cin.nextLine().toUpperCase().charAt(0);
    } // end method

    private static void add(SLND<String> theList) {
    	System.out.print("Add to " + theList.name + "? ");
        String item = cin.nextLine();
        theList.add(item); // the add method may throw exception, handled within "maintain"

        System.out.println("Add succeeded");
    } // end method

    private static void find(SLND<String> theList) {
	// TODO: complete this method

    } // end method

    private static void remove(SLND<String> theList) {
	// TODO: complete this method

    } // end method

    private static void tellPurpose() {
    	System.out.println("Party Planner: This program lets you maintain" +
                "\n\ta guest list and a food/beverage list");
    } // end method

} // end class

// ----------------- abstract generic class SLND (Sorted List No Duplicates)
// No changes needed here
abstract class SLND<E extends Comparable<E>> {

    public final String name;

    public SLND(String name) {
        this.name = name;
    }

    public abstract void add(E item);

    public abstract void remove(E item);

    public abstract boolean find(E item);

    public abstract String toString();
} // end class

// ----------------- generic class Node (used to create singly linked list)
// No changes needed here
// The fields (instance variables) are public
class Node<T> {

    public T data;
    public Node next;

    // Constructor 0
    public Node() {
        this(null);
    }

    // Constructor 1
    public Node(T data) {
        this(data, null); // use Constructor 2 specifying both instance variables
    }

    // Constructor 2
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
} // end class

// ----------------- generic class SLND_LinkedList
class SLND_LinkedList<E extends Comparable<E>> extends SLND<E> {

    // fields of Node are public, but making head private does data hiding
    private Node<E> head;

    public SLND_LinkedList(String name) {
        super(name);
        head = null;
    }    // Constructor

    public void add(E item) throws IllegalStateException {
        Node<E> cur = head, prev = null;

        // TODO: Find the (possible) insertion point.

        // TODO: if duplicate item throw IllegalStateException 

        // TODO: Insert the new node just before cur. may need to modify head

    } // end method

    
    public void remove(E item) throws NoSuchElementException {
	// TODO: complete this method, declare local variables needed

	// if item cannot be located, throw NoSuchElementException 

	// remove the item, may have to modify head

    } // end method

    public boolean find(E item) {
	// TODO: complete this method, may need local variables

	// if match found return true


        // if no match found
        return false;
    } // end method

    public String toString() {
	// TODO: complete this method, may need local variables
        
        return "Empty List\n"; // stub code remove when method completed
    } // end method


    // add any other private methods you want
    
} // end class
