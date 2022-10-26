import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
public class progtwo {
	// setup number format for rounding
	static NumberFormat f = new DecimalFormat("#0.0");
	// init scanner
	static Scanner sc = new Scanner(System.in);
	// func for getting coords
	public static Boolean testnegative(int input) {
		if(input > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static int getCoordinate(String prompt) {
		System.out.print(prompt);
		int temp = sc.nextInt();
		if(testnegative(temp)) {
			System.out.println("Input cannot be negative");
			System.exit(1);
		}
		return temp;
	}
	// calc side length func
	public static double calcSideLength(int x1, int y1, int x2, int y2) {
		if(testnegative(x1)) {
			System.out.println("point cannot be negative");
			System.exit(1);
		}
		if(testnegative(y1)) {
			System.out.println("point cannot be negative");
			System.exit(1);
		}
		if(testnegative(x2)) {
			System.out.println("point cannot be negative");
			System.exit(1);
		}
		if(testnegative(y2)) {
			System.out.println("point cannot be negative");
			System.exit(1);
		}
		return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
	}
	// calc alpha angle func
	public static double calcAlphaAngle(double a, double b, double c) {
		if(testnegative((int)a)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)b)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)c)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		return Math.toDegrees(Math.acos((Math.pow(b, 2)+Math.pow(c, 2)-Math.pow(a, 2))/(2.0*b*c)));
	}
	// calc beta angle func
	public static double calcBetaAngle(double a, double b, double c) {
		if(testnegative((int)a)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)b)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)c)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		return Math.toDegrees(Math.acos((Math.pow(a, 2)+Math.pow(c, 2)-Math.pow(b, 2))/(2.0*a*c)));
	}
	// calc gamma angle func
	public static double calcGammaAngle(double a, double b, double c) {
		if(testnegative((int)a)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)b)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)c)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		return Math.toDegrees(Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/(2.0*a*b)));
	}
	// calc perimeter func
	public static double calcPerimeter(double side1, double side2, double side3) {
		if(testnegative((int)side1)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)side2)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)side3)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		return side1+side2+side3;
	}
	// calc area func
	public static double calcArea(double a, double b, double c) {
		if(testnegative((int)a)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)b)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		if(testnegative((int)c)) {
			System.out.println("side length cannot be negative");
			System.exit(1);
		}
		double s = (a+b+c)/2.0;
		return Math.sqrt( (s * (s-a))*(s-b)*(s-c) );
	}
	// main method
	public static void main(String[] args) {
		// get all coords
		int px1 = getCoordinate("Enter the x cord of first corner p: ");
		int py1 = getCoordinate("Enter the y cord of first corner p: ");
		int px2 = getCoordinate("Enter the x cord of second corner p: ");
		int py2 = getCoordinate("Enter the y cord of second corner p: ");
		int px3 = getCoordinate("Enter the x cord of third corner p: ");
		int py3 = getCoordinate("Enter the y cord of third corner p: ");
		
		// calc all sides
		double side1 = calcSideLength(px1,py1,px2,py2);
		double side2 = calcSideLength(px2,py2,px3,py3);
		double side3 = calcSideLength(px1,py1,px3,py3);
		
		// display all outputs
		System.out.println("\nThe lengths of the three sides are "+side1+","+f.format(side2)+","+side3);
		System.out.println("\nThe three angles of the triange are "+f.format(calcAlphaAngle(side1,side2,side3))+" degrees, "+f.format(calcBetaAngle(side1,side2,side3))+" degrees and "+f.format(calcGammaAngle(side1,side2,side3))+" degrees");
		System.out.println("\nThe perimeter of the triangle is "+f.format(calcPerimeter(side1,side2,side3))+", and the area of the triangle is "+f.format(calcArea(side1,side2,side3)));
	}
}
