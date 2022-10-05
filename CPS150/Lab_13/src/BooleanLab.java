/*
 * BooleanLab.java
 */

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Java booleans and Boolean Logic
 *
 * @author Ryan Zmuda
 */
public class BooleanLab
{
    /**
     * Add the code as described by (and immediately below) each of
     *   the comment blocks labeled Lab Part 1 - Lab Part 5 in the main method,
     *   as well as the method implementations below the line labeled
     *   ADD BOOLEAN METHODS IMMEDIATELY BELOW THIS LINE.
     */
    public static void main(String[] args)
    {
        /*
            Lab Part 1: Declare boolean variables for the following predicates:
                a. I am taking a Math course
                b. I am taking a History course
                c. I am taking an English course
                d. I am taking a Computer Science course
            
            For example, you could declare the last variable (d) as:
                boolean takingCSCourse;
        */
        
        // ADD Lab Part 1 CODE HERE
        
    	Boolean math;
    	Boolean History;
    	Boolean English;
    	Boolean CPS;
    	
        /*
            Lab Part 2: Initialize each of the boolean variables declared in Lab Part 1 above
                      based on whether or not your are taking a course in each of
                      those disciplines
            
            For example, you would initialize the last variable (Lab Part 1.d) as:
                takingCSCourse = true;
        */
        
        // ADD Lab Part 2 CODE HERE
    	math = true;
    	History = false;
    	English = false;
    	CPS = true;
        /*
            Lab Part 3: Using only boolean operators, write boolean expressions,
                     and output their results, for each of the following
                     Boolean expressions on the variables declared in Lab Part 1
                     and initialized in Lab Part 2:
               a. I am not taking a Math course
               b. I am taking a History course
               c. I am not taking an English course
               d. I am taking a Computer Science course
            
            For example, you could output expression (a) as:
                System.out.println("I am not taking a Math course is " + !takingMathCourse);
        */
        
        // ADD Lab Part 3 CODE HERE
        System.out.println("I am not taking a Math course is " + !math);
        System.out.println("I am taking a history course is " + History);
        System.out.println("I am not taking a english course is " + !English);
        System.out.println("I am taking a CPS course is " + CPS);
        /*
            Lab Part 4: Using only boolean operators, write boolean expressions,
                     and output the results, for each of the following
                     Boolean expressions on the variables declared in Lab Part 1
                     and initialized in Lab Part 2:
               a. I am neither taking a Math nor a Computer Science course
                  (i.e., I am not taking a Math course and I am not taking a Computer Science course)
               b. I am taking a History course and I am taking an English course
               c. I am taking a Math course or I am taking an English course
               d. I am taking a History course or I am taking a Computer Science course
            
            For example, you could output the last expression (d) as:
                System.out.println("Taking History or Computer Science is " + (takingHistoryCourse || takingCSCourse));
        */
        
        // ADD Lab Part 4 CODE HERE
        System.out.println("Not Taking Math or Computer Science is " + (!math || !CPS));
        System.out.println("Taking history and english " + (History && English));
        System.out.println("Taking history or english " + (History || English));
        System.out.println("taking history or computer science " + (History || CPS));
        /*
            Lab Part 5:
            *** NOTE: Complete this part AFTER adding the method implementations (below) ***
                1. Write a boolean method implementation (i.e., a method that has a boolean
                     result) for each of the following Boolean expressions:
                   a. I am taking a Computer Science Course or I am not taking a Computer Science course
                   b. I am either taking a Math course or I am taking an English course and I am taking a History course
                   c. I am either taking a Computer Science course or I am taking a Math course and I am taking an English course or I am taking a History course
                (Write the method definitions following the line below labeled
                     "ADD BOOLEAN METHODS IMMEDIATELY BELOW THIS LINE")
                2. In this main method, add a call to each of the methods
                   defined in part Lab Part 5.1, and output its result
            
            For example, you would output the result of calling the first method (a) as:
                System.out.println("Taking Computer Science or not is " + CSOrNotCS(takingCSCourse));
        */
        
        // ADD Lab Part 5 CODE HERE
        System.out.println("Taking Computer Science or not is " + CSOrNotCS(CPS));
        System.out.println("Math or English And History " + MathOrEnglishAndHistory(math,English,History));
        System.out.println("CS Or Math And English Or History " + CSOrMathAndEnglishOrHistory(CPS,math,English,History));
    } // end main method
    
    /* IMPLEMENT BOOLEAN METHODS IMMEDIATELY BELOW THIS LINE */
    
    /*
     * CSOrNotCS(boolean) -> boolean
     *
     * method is given a boolean value for whether I am taking a Computer Science course
     * method returns the boolean value of "CS or not CS"
     *
     * ADD METHOD IMPLEMENTATION BELOW THE FOLLOWING LINE
     */
    public static Boolean CSOrNotCS(Boolean b) {
    	return b||!b;
    }
    
    /*
     * MathOrEnglishAndHistory(boolean, boolean, boolean) -> boolean
     *
     * method is given a boolean values for whether or not:
     *    1. I am taking a Math course
     *    2. I am taking an English course
     *    3. I am taking a History course
     * method returns the boolean value of "Math or English and History"
     *
     * ADD METHOD IMPLEMENTATION BELOW THE FOLLOWING LINE
     */
    public static Boolean MathOrEnglishAndHistory(Boolean a,Boolean b, Boolean c) {
    	return (a || b) && c;
    }
    /*
     * CSOrMathAndEnglishOrHistory(boolean, boolean, boolean, boolean) -> boolean
     *
     * method is given a boolean values for whether or not:
     *    1. I am taking a Computer Science course
     *    1. I am taking a Math course
     *    2. I am taking an English course
     *    3. I am taking a History course
     * method returns the boolean value of "CS or Math and English or History"
     *
     * ADD METHOD IMPLEMENTATION BELOW THE FOLLOWING LINE
     */
    public static Boolean CSOrMathAndEnglishOrHistory(Boolean a,Boolean b, Boolean c,Boolean d) {
    	return (a||b)&&(c||d);
    }
     
} // end class BooleanLab