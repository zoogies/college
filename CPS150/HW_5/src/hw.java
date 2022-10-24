import java.util.Scanner;

public class hw {

	public static void main(String[] args) {
		
		// 3.6
		double x = -10;
		double y;
		if(x<0) { y=x*-1; }
		
		// 3.7
		// floating point numbers are more precise and have more digits
		int n = 10;
		float x2 = 10f;
		System.out.println(10 == n);
		System.out.println(x2 == 10);
		
		// 3.8
		int x11 = 1;
		int x22 = 1;
		int y11 = 3;
		int y22 = 2;
		if(x11 == x22 && y11 == y22) {
			System.out.println("Same pixel");
		}
		else if(Math.abs(x11 - x22) < 5 && Math.abs(y11 - y22) < 5) {
			System.out.println("Very close pixels");
		}
		
		// 3.9
		// if(floor = 13) ERROR: floor cannot be resolved to a variable
		// count == 0; ERROR: count cannot be resolved to a variable
		// gives a syntax error
		
		// 3.11
		char letter ='a';
		int number = 1;
		String color;
		if(letter == 'a' || letter == 'e' || letter == 'c' || letter == 'g') {
			if(number % 2 != 0) {
				color = "black";
			}
			else {
				color = "white";
			}
		}
		else {
			if(number % 2 == 0) {
				color = "black";
			}
			else {
				color = "white";
			}
		}
		
		// 3.12
		int start1 = 1000;
		int start2 = 1100;
		int end1 = 1200;
		int end2 = 1300;
		int s;
		int e;
		if (start1 > start2) {
			s = start1;
		}
		else {
			s = start2;
		}
	    if(end1 < end2) {
	    	e = end1;
	    }
	    else {
	    	e = end2;
	    } 
	    if(s < e) {
	    	System.out.println("The appointments overlap.");
	    }
	    else {
	    	System.out.println("The appointments dont overlap.");
	    }
	    
	    // 10-12 && 11-13 OVERLAP
	    // 10-11 && 12-13 NO NOT OVERLAP
	    
	    // 3.18
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter month in lowercase: ");
	    String month = sc.next();
	    System.out.print("Enter date: ");
	    int date = sc.nextInt();
	    
	    if(month == "january" && date == 1) {
	    	System.out.println("New years day!");
	    }
	    else if(month == "july" && date == 4) {
	    	System.out.println("Independance day!");
	    }
	    else if(month == "november" && date == 11) {
	    	System.out.println("Veterans day!");
	    }
	    else if(month == "december" && date == 25) {
	    	System.out.println("Christmas day!");
	    }
	    
	    // 3.19
	    int score = 66;
	    if(score >= 90) {
	    	System.out.println("A");
	    }
	    else if(score >= 80) {
	    	System.out.println("B");
	    }
	    else if(score >= 70) {
	    	System.out.println("C");
	    }
	    else if(score >= 60) {
	    	System.out.println("D");
	    }
	    else {
	    	System.out.println("F");
	    }
	    
	    // 3.22
	    // nested if statements can be faster as they shorten the amount of logic operations performed
	    
	    // if x
	    // else
	    // if y
	    // else
	    // vs:
	    // if x || y
	    // if x
	    // if y
	    
	    // 3.23
	    // does not matter
	    // if red
	    // else
	    
	    // DOES matter:
	    // if money less than 1
	    // else 
	    // if money equals 0
	    // explained: if you want to see if money is zero you should catch that instead of just less than 0 because you wont reach the 0 case
	    
	}

}
