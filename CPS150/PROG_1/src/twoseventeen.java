import java.util.Scanner;

public class twoseventeen {
    public static void main(String[] args) {
    	// setup scanner
        Scanner in = new Scanner(System.in);
        // get input
        System.out.print("Enter first time: ");
        int firstTime = in.nextInt();
        System.out.print("Enter second time: ");
        int secondTime = in.nextInt();
        // calculate
        int difference = secondTime - firstTime;
        int minutes = Math.abs(difference - (int) (difference / 100 * 100));
        if (difference < 0) {
            difference += 2400;
        }
        int hours = difference / 100;
        // output
        System.out.println("The difference is " + hours + " hours and " + minutes + " minutes.");
    }
}