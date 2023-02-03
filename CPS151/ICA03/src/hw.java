import java.util.Scanner;
public class hw {
    final static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("CPS 151 In-class assignment 3 by Ryan Zmuda\n");
        System.out.print("Enter n: ");
        int n = cin.nextInt();
        
        long f = fib(n, 0);

        System.out.println("\nfib(" + n + ") = " + f);
        System.out.println("\nCPS 151 In-class assignment 3 complete");
    } // end main
    static long result;
    // standard fibonacci number computation using recursion
    static long fib(int n, int level) {
    	indent(level);
    	System.out.println("Entering fib: n = "+n);
        if (n < 0) {
        	terminate("Negative argument value not allowed, program ended");
        }
        if (n <= 1) {
        	indent(level);
        	System.out.println("Exiting fib: n = "+n+" return value = "+n);
            return n;
        }
        else {
            result = fib(n - 1, level + 1) + fib (n - 2, level + 1);	
        }
        indent(level);
        System.out.println("Exiting Fib: n = "+n+" return value = "+result);
        return result;
    } // end fib
    
    private static void indent(int level) {
        for(int Lcv = 1; Lcv <= level; Lcv++)
        	System.out.print("   ");
    } // end indent

    private static void terminate(String errorMessage) {
    	System.out.println(errorMessage);
        System.exit(1);
    } // end terminate
}