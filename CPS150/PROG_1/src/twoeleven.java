import java.util.Scanner; 
public class twoeleven {
	 public static void main(String[] args) {
		   // setup scanner
		   Scanner sc = new Scanner(System.in);
		   // get inputs
		   System.out.print("Input the number of gallons of gas in the tank: ");
		   double gallons = sc.nextDouble();
		 
		   System.out.print("Input the fuel efficiency in miles per gallon: ");
		   double efficiency = sc.nextDouble();
		 
		   System.out.print("Input the price of gas per gallon: ");
		   double price = sc.nextDouble();
		 
		   // make calculations
		   double cost = 100 * price / efficiency;
		   double range = efficiency * gallons;
		 
		   // output
		   System.out.printf("The cost per 100 miles is $%.2f%n", cost);
		   System.out.printf("The range of the car is %.2f miles%n", range);
	 }
}