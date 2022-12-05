package progsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class progsix {
	
	// declare variables
	static ArrayList<String> lines = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	
	// open method adapted from an online example
	public static void open(String p) {
		Scanner s;
		try {
			s = new Scanner(new File(p));
			lines.clear();
			while (s.hasNextLine()){
			    lines.add(s.nextLine()); 
			}
			s.close();
			System.out.println("File opened successfully");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	// save method also adapted from an online example
	public static void save(String p) {
		Path output = Paths.get(p);
	    try {
	        Files.write(output, lines);
	        System.out.println("File saved successfully.");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.out.println("File could not be saved! Check your path!");
	    }
	}
	
	// Display function that has a special case for empty file
	private static void display()
	{
		if(lines.size() == 0) {
			System.out.println("\nFile contents:");
			System.out.println("!!! The file is empty !!!");
		}
		else {
			System.out.println("\nFile contents:");
			for(String s: lines) {
				System.out.println(s);
			}
		}
	}
	
	// function to display specific line
	private static void displayline(int i) {
		if(lines.size() == 0) {
			System.out.println("!!! The file is empty !!!");
		}
		else {
			if(lines.size() < i) {
				System.out.println("This line does not exist");
			}
			else {
				System.out.println("\nLine "+i+" contents:");
				System.out.println(lines.get(i -1));
			}
		}
	}
	
	// function to append to the end of the file
	public static void append(String s) {
		lines.add(s);
	}
	
	// function to insert to the file at an index
	public static void insert(int i, String s) {
		lines.add(i-1, s);
	}
	
	// function to replace a line at an index
	public static void replace(int i, String s) {
		lines.set(i-1, s);
	}
	
	// remove a line at an index
	public static void remove(int i) {
		lines.remove(i-1);
	}
	
	// main method
	public static void main(String[] args) {
		// variable to keep session runnning
		Boolean running = true;
		
		// header text
		System.out.println("Welcome to zmuda text editor v12.1.22");
		System.out.println("INFO - Line numbers start at 1");
		System.out.println("");
		
		// loop to persist running session
		while(running){
			// display all options
			System.out.println("\nPlease select option: ");
			System.out.println("1 - open");
			System.out.println("2 - save");
			System.out.println("3 - display");
			System.out.println("4 - display specific line");
			System.out.println("5 - append");
			System.out.println("6 - insert");
			System.out.println("7 - replace");
			System.out.println("8 - remove");
			System.out.println("9 - exit");
			System.out.print(">");
			
			int selection = sc.nextInt();
			
			// switch statement to handle selections
			switch(selection) {
			  	case 1: // open
			  		System.out.println("Please enter the full path to the file:");
			  		String s = sc.next();
			  		open(s);
			  		break;
			  	case 2: // save
			  		System.out.println("Please enter the full path to save the file:");
			  		String s22 = sc.next();
			  		save(s22);
			  		break;
			  	case 3: // display whole
			  		display();
			  		break;
			  	case 4: // display line
			  		System.out.println("Please specify a line number:");
			  		selection = sc.nextInt();

			  		displayline(selection);
			  		break;
			  	case 5: // append
			  		System.out.println("Please enter the text to append:");
			  		String s4 = sc.next();
			  		append(s4);
			  		break;
			  	case 6: // insert
			  		System.out.println("Please enter the line number to insert at:");
			  		selection = sc.nextInt();
			  		
			  		System.out.println("Please enter the text to insert:");
			  		String s1 = sc.next();
			  		insert(selection,s1);
			  		break;
			  	case 7: // replace
			  		System.out.println("Please enter the line number to replace:");
			  		selection = sc.nextInt();
			  		
			  		System.out.println("Please enter the new text:");
			  		String s2 = sc.next();
			  		replace(selection,s2);
			  		break;
			  	case 8: // remove
			  		System.out.println("Please specify a line number:");
			  		selection = sc.nextInt();
			  		
			  		remove(selection);
			  		break;
			  	case 9: // exit
			  		running = false;
			  		break;
			  	default: // default case
			  		break;
			}
		}
	}
}
// Ryan Zmuda