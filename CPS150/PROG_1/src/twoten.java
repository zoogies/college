import java.util.*;
public class twoten {
	public static void main(String[] args) {
		// setup scanner
		Scanner sc = new Scanner(System.in);
		
		// get user inputs
		
		System.out.print("New car cost: ");
		int cost = sc.nextInt();
		System.out.print("Estimated miles per year: ");
		Double mpy = sc.nextDouble();
		System.out.print("Estimated gas price: ");
		Double gp = sc.nextDouble();
		System.out.print("efficiency in mpg: ");
		Double mpg = sc.nextDouble();
		System.out.print("resale value after 5 years: ");
		int resale = sc.nextInt();
		
		//make calculations and output
		
		Double gallons = (mpy/mpg);
		System.out.println(gallons + " gallons of gas are used per year");
		System.out.println("$"+gallons*gp + " is spent on gas each year");
		System.out.println("After 5 years, this cars total cost is: $"+(5*gallons*gp + (cost - resale)));
		
		// Sample run 1 (2022 civic) 
		// cost: 22550
		// mpy: 15000
		// gas: 3.67
		// mpg: 33
		// resale: 22550
		// 454.54 gallons of gas are used per year
		// $1668.18 is spent on gas each year
		// After 5 years, this cars total cost is: $8340.90
		
		// Sample run 2 (2022 honda insight)
		// New car cost: 25760
		// Estimated miles per year: 15000
		// Estimated gas price: 3.67
		// efficiency in mpg: 55
		// resale value after 5 years: 25760
		// 272.72 gallons of gas are used per year
		// $1000.90 is spent on gas each year
		// After 5 years, this cars total cost is: $5004.54
	}
}
