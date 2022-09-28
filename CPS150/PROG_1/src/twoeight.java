
import java.util.Scanner;

public class twoeight {
	public static void main(String[] args) {
		//setup scanner
		Scanner input = new Scanner(System.in);
		// get inputs
		System.out.println("Enter the length of the rectangle: ");
		double length = input.nextDouble();
		System.out.println("Enter the width of the rectangle: ");
		//calculate
		double width = input.nextDouble();
		double area = length * width;
		double perimeter = 2 * (length + width);
		double diagonal = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
		//output
		System.out.println("The area of the rectangle is: " + area);
		System.out.println("The perimeter of the rectangle is: " + perimeter);
		System.out.println("The length of the diagonal is: " + diagonal);
	}
}