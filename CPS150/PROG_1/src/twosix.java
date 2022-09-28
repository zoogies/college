import java.util.*;
public class twosix {

	public static void main(String[] args) {
		// setup scanner
		Scanner sc = new Scanner(System.in); 
		// get inputs
	    System.out.print("Enter a value for meters: ");
	    // make calculations
	    double meters = sc.nextDouble(); 
	    double miles = meters * 0.00062137;
	    double feet = meters * 3.28084;
	    double inches = meters * 39.3701;
	    // output answer
	    System.out.println(meters + " meters is " + miles + " miles, " + feet + " feet, or " + inches + " inches.");
	}

}
