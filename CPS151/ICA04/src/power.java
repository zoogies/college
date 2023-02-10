import java.util.Scanner;

public class power {
    final static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean loop = true;
        System.out.print("CPS 151 ICA 04 Power calculation by Ryan Zmuda\n\n");
        
        while(loop) {
        	System.out.print("Enter base (double) or 0.0 to exit loop: ");
            double base = cin.nextDouble();
            if(base == 0.0) {
            	loop = false;
            }
            else {
            	System.out.print("Enter the power to raise it to (positive int): ");
                int expo = cin.nextInt();
                
                double result1 = slowPower(base, expo);
                double result2 = fastPower(base, expo);
                System.out.println("Result from slow power = " + result1);
                System.out.println("Result from fast power = " + result2);
                System.out.println("Result from math.pow = " + Math.pow(base, expo));	
                System.out.println();
            }
        }
    } // end main

    private static double slowPower(double base, int expo) {
        if (expo == 0)
            return 1.0;
        else
            return base * slowPower(base, expo-1);
    } // end method

    private static double fastPower(double base, int expo) {
        if (expo == 0)
            return 1.0;
        else if (expo % 2 != 0) {
        	return base * fastPower(base, expo-1);
        }
        else {
        	return Math.pow(base, expo/2) * Math.pow(base, expo/2);
        }
            
    } // end method
}
