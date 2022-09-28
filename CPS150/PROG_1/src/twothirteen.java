import java.util.Scanner; 

public class twothirteen { 
	public static void main(String[] args) { 
		// setup scanner
		Scanner sc = new Scanner(System.in); 
		// get input
		System.out.print("Enter an integer between 1,000 and 999,999: "); 
		String num = sc.next(); 
		// calculate and output
		System.out.println("The number without a comma is " + num.substring(0,num.length()-4)+num.substring(num.length()-3,num.length())); 
	} 
}