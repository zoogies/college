import java.util.Scanner;

public class assign6 {

    final static Scanner cin = new Scanner(System.in);
    final static Bag<String> friends = new LinkedBag<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char cmd;
        System.out.println("CPS 151 ICA 06 by Ryan Zmuda");
        System.out.print("\nA/C/F/R/P/S/Q? ");
        cmd = cin.next().trim().toUpperCase().charAt(0);
        while (cmd != 'Q') {
            if (cmd == 'A') {
                add();
            } else if (cmd == 'C') {
                count();
            } else if (cmd == 'F') {
                find();
            } else if (cmd == 'R') {
                remove();
            } else if (cmd == 'S') {
            	System.out.println("The bag has " + friends.size() + " items");
            } else if (cmd == 'P') {
            	System.out.println(friends);
            } else {
            	System.out.println("Invalid command");
            }
            System.out.print("\nA/C/F/R/P/S/Q? ");
            cmd = cin.next().trim().toUpperCase().charAt(0);
        } // end loop

    } // end main

    private static void add() {
        String name = getWord("Enter friend's first name: ");
        friends.add(name);
        System.out.println("Name added");
    } // end method

    private static void find() {
        String name = getWord("Enter friend's first name: ");
        if (friends.find(name)) {
        	System.out.println("The name " + name + " is in bag");
        } else {
        	System.out.println("The name " + name + " is not in bag");
        }
    } // end method

    private static void remove() {
        String name = getWord("Enter friend's first name: ");
        if (friends.remove(name)) {
        	System.out.println("The name " + name + " was removed");
        } else {
        	System.out.println("The name " + name + " is not in bag, remove failed");
        }
    } // end method

    private static void count() {
        String name = getWord("Enter friend's first name: ");
        System.out.println("The name occurs " + friends.count(name) + " times in the bag");
    } // end method

    static String getWord(String prompt) {
    	System.out.print(prompt);
        return cin.next();
    } // end method

} // end class

// ------------------- interface Bag<E>
interface Bag<E> {

    void add(E item);

    boolean remove(E item);

    boolean find(E item);

    int count(E item);

    int size();

    @Override
    String toString();
} // end interface

// ------------------- class LinkedBag<E>
class LinkedBag<E> implements Bag<E> {

    private Node<E> head;

    public LinkedBag() {
        head = null;
    }

    @Override
    public void add(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public boolean remove(E item) {
        Node<E> currNode = head;
        Node<E> prevNode = null;
        
        while (currNode != null) {
        	
            if (currNode.data.equals(item)) {
                if (prevNode == null) {
                    head = currNode.next;
                } 
                else {
                    prevNode.next = currNode.next;
                }
                return true;
            }
            
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        return false;
    }

    @Override
    public boolean find(E item) {
        Node<E> currNode = head;

        while (currNode != null) {
            if (currNode.data.equals(item)) {
                return true;
            }
            
            currNode = currNode.next;
        }
        
        return false;
    }

    @Override
    public int count(E item) {
        int count = 0;
        Node<E> currNode = head;
        
        while (currNode != null) {
            if (currNode.data.equals(item)) {
                count++;
            }
            currNode = currNode.next;
        }
        
        return count;
    }

    @Override
    public int size() {
        int count = 0;
        Node<E> currNode = head;
        
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        
        return count;
    }

    public String toString() {
    	String result = "[";
    	Node<E> currNode = head;
    	
    	while (currNode != null) {
    		result += currNode.data;
    		
    		if (currNode.next != null) {
    			result += ", ";
    		}
    		
    		currNode = currNode.next;
    	}
    	
    	result += "]";
    	
    	return result;
    }

} // end class LinkedBag<E>

// ------------------- class Node<T>
class Node<T> {

    public T data;
    public Node<T> next;

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