import java.util.Random;

public class icao2 {
    final static Random rand = new Random();
    final static int MAX_SIZE = 10;	// amount of storage for the intList
    static int size = 0;            // number of values actually in the intList
    static int[] intList = new int[MAX_SIZE];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("CPS 151 In-class assignment 2 by Ryan Zmuda");
        setRandom(intList, 100);
        printList(intList, MAX_SIZE, "\nArray before sorting");
        sort(intList);
        printList(intList, MAX_SIZE, "\nArray after sorting");
    } // end main

    // prints partially filled array with a legend
    private static void printList(final int[] arr, final int size,
            final String legend) {
    	System.out.println(legend);
        for (int k = 0; k < size; k++) {
        	System.out.print(" " + arr[k]);
        }
        System.out.println();
    } // end printList

    // move items from pos:size-1 one position down (higher subscripts)
    private static void shiftDown(int[] arr, int size, int pos) {
        // Write the code (use code from ICA 1)
    	for(int i=size; i>pos; i--) {
    		int previous = intList[i-1];
    		intList[i] = previous;
    	}
    } // end shiftDown

    private static void setRandom(int[] arr, final int range) {
        for (int k = 0; k < arr.length; k++) {
            arr[k] = rand.nextInt(range);
        }
    } // end setRandom

    private static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            // assume arr[0:k-1] sorted
            int save = arr[k]; // arr[k] may be overwritten later, so save that value
            int pos = findPos(arr, k, save); // find where to insert save in arr[0:k-1]
            shiftDown(arr, k, pos);
            arr[pos] = save;
            // arr[0:k] is now sorted with k+1 values
            printList(arr, MAX_SIZE, "\nAfter pass " + k);
        } // end for
    } // end sort

    // find the right place for item to be inserted within arr[0:size-1]
    private static int findPos(int[] arr, int size, int item) {
        // write the code
        for(int i=0;i<size;) {
        	if(i < size && item >= arr[i]) {
        		i++;
        	}
        	else {
        		return i;
        	}
        }
        return size; // stub, keeps compiler happy
    } // end findPos
}
