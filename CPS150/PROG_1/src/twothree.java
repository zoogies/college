import java.util.*;
public class twothree {

	public static void main(String[] args) {
		// setup scanner
		Scanner sc = new Scanner(System.in);
		// get inputs
		System.out.print("Enter number: ");
		Double db = sc.nextDouble();
		// output
		System.out.println("The number "+db+" squared is "+Math.pow(db, 2));
		System.out.println("The number "+db+" cubed is "+Math.pow(db, 3));
		System.out.println("The number "+db+" to the fourth is "+Math.pow(db, 4));
	}

}
