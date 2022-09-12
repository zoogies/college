/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Arithmetic Expressions in Java
 * 
 * Name: Ryan Zmuda
 */

public class ArithmeticExpressions
{
  public static void main(String[] args)
  {
    // start adding code after this line
    int a = 3;
    int b = 4;
    int c = 5;
    int d = 17;
    System.out.print("(a + b)/ c : ");
    System.out.println((a + b)/ c);
    // 3 and 4 are added with sum 7
    // 7 is divided by 5 with quotient 1
    System.out.print("a + b / c : ");
    System.out.println(a + b / c);
    // 4 is divided by 5 with quotient 0
    // 3 is added to 0 with sum 3
    System.out.print("a++ : ");
    System.out.println(a++);
    // 3 is incremented by 1 with sum 4
    System.out.print("a-- : ");
    System.out.println(a--);
    // 4 is reduced by 1 with sum 3
    System.out.print("a + 1 : ");
    System.out.println(a + 1);
    // 1 is added to 3 with sum 4
    System.out.print("d % c : ");
    System.out.println(d % c);
    // the remainder of 17 divided by 5 is 2
    System.out.print("d / c : ");
    System.out.println(d / c);
    // the most amount of times 5 can go into 17 is 3
    System.out.print("d % b : ");
    System.out.println(d % b);
    // the remainder of 17 divided by 4 is 1
    System.out.print("d / b : ");
    System.out.println(d / b);
    // the most amount of times 4 can go into 17 is 4
    System.out.print("d + a / d + b : ");
    System.out.println(d + a / d + b);
    // 3 is divided by 17 with result 0
    // 17 and 4 are added to 0 with sum 21
    System.out.print("(d + a) / (d + b) : ");
    System.out.println((d + a) / (d + b));
    // 3 is added to 17 with sum 20
    // 17 is added to 4 with sum 21
    // 20 is divided by 21 with result 0
    System.out.print("Math.sqrt(b) : ");
    System.out.println(Math.sqrt(b));
    // the square root of 4 is 2
    System.out.print("Math.pow(a, b) : ");
    System.out.println(Math.pow(a, b));
    // 3 to the 4th power is 81
    System.out.print("Math.abs(-a) : ");
    System.out.println(Math.abs(-a));
    // the absolute value of -3 is 3
    System.out.print("Math.max(a, b) : ");
    System.out.println(Math.max(a, b));
    // the greater value of 3 and 4 is 4
    // stop adding code before this line
  } // end main method
} // end ArithmeticExpressions class