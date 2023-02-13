import java.util.Random;

public class sorters {
	    static Random rand = new Random();
	    
	    public static void printarr(String category, int[] arr) {
	    	System.out.print(category+" array: [");
	    	for(int i=0;i<arr.length;i++) {
	    		if(i==arr.length-1) {
	    			System.out.print(arr[i]);
	    		}
	    		else {
	    			System.out.print(arr[i]+",");
	    		}
	    	}
	        System.out.println("]");
	    }
	    
	    public static void main(String[] args) {
	        // Sign on
	        System.out.println("CPS 151 HW Asgn 1 by Ryan Zmuda");
	        // Demonstrate that the sorts work and show sample comparison counts
	        demoBubbleSort();
	        demoMergeSort();
	        
	        // Collect comparison counts for sorting random arrays using both
	        // sorting techniques for arrays of various sizes and report (2 sets)
	        collectAndPrintData();
	        collectAndPrintData();
	        System.out.println("\nHW Asgn 1 complete.");
	    } // end main

	    private static void demoBubbleSort() {
	        int arr[] = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	        int brr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	        
	        System.out.println("\nOptimal Bubble Sort comparison counts");
	        System.out.println("==================================================");
	        
	        printarr("Original",arr);
	        
	        int comparisons = 0;
	        
	        int n = arr.length;     // size of array
	        
	        for (int pass = 1; pass < n; pass++) {
	            for (int k = 0; k < n - 1; k++) {
	                if (arr[k] > arr[k + 1])    // out of order
	                	comparisons++;
	                	swap(arr, k, k + 1);
	                
	            }} // end inner loop
	        
	        printarr("Sorted",arr);
	        System.out.println(comparisons + " comparisons\n");
	        
	        printarr("Original",brr);
	        
	        comparisons = 0;
	        
	        n = brr.length;
	        Boolean noswap = true;
	        for (int pass = 1; pass < n; pass++) {
	            for (int k = 0; k < n - 1; k++) {
	            	noswap = true;
	                if (brr[k] > brr[k + 1])    // out of order
	                	comparisons++;
	                	swap(brr, k, k + 1);
	                	noswap = false;
	            	}
	            } // end inner loop 
	        
	        printarr("Sorted",brr);
	        System.out.println(comparisons + " comparisons\n");

	    } // end method

	    private static void demoMergeSort() {
	        int arr[] = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	        int brr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	        int crr[] = {8, 15, 10, 13, 12, 9, 11, 14, 16, 4, 5, 6, 7, 1, 3, 2};
	        
	        System.out.println("\nOptimal Merge Sort comparison counts");
	        System.out.println("==================================================");
	        
	        // TODO: Sort these arrays using merge sort, show original and sorted
	        // arrays and the  comparison counts (see sample output)

	    } // end method

	    private static void collectAndPrintData() {
	        // TODO: print the section and table column headers
	        // TODO: for arrays of size 1000 to 10000, create two copies of 
	        // the same random array, sort one by bubble sort, the other by
	        // merge sort, print array size and the two comparison counts
	        // as one row of data in the table

	    } // end method

	    // optimized bubble sort as described in the handout
	    private static int bubbleSort(int[] arr) {
	        int compCount = 0;  // comparison counter
	        // declare any other variables you need

	        // TODO: implement optimized bubble sort as described in handout

	        return compCount;
	    } // end bubbleSort

	    // sorts an array of integers (shell function for public use)
	    public static int mergeSort(final int[] arr) {
	        return mergeSort(arr, 0, arr.length - 1);
	    } // end public sort

	    // sort the segment arr[low:high], its length is (high - low + 1)
	    private static int mergeSort(final int[] arr, final int low, final int high) {
	        int compCount = 0;  // counts number of comparisons made

	        // Base case: a segment of length <= 1 is sorted by definition
	        if (high - low <= 0) {
	            return compCount;
	        }

	        // Recursive case: segment length > 1
	        // Consider arr[low:high] split into arr[low:mid] and arr[mid+1:high]
	        // and sort them recursively where mid = (low + high) / 2
	        // Also add up the comparison counts from sorting the two sublists

	        // merge arr[low:mid] and arr[mid+1:high] into arr[low:high]
	        // add comparison count to the total above

	        // return the accumulated count
	        return compCount;
	    } // end private sort

	    private static int merge(final int[] arr, final int low, final int high) {
	        // array segment arr[low:high] contains two sorted subsegments 
	        // arr[low:mid] and arr[mid+1:high] where mid = (low + high)/2
	        int compCount = 0;  // counts number of comparisons made
	        // TODO: declare other variables you need
	        
	        // TODO: code the merge process, increment the comparison counter
	        // while both segments have values to be processed
	        
	        // TODO: handle the left over values from one segment, this process
	        // does not contribute to the comparison count
	        
	        // TODO: copy back from the merged segment to arr[low:high]
	        
	        return compCount;
	    } // end merge

	    // utility method, loads random integer values in an array
	    // the caller is responsible for allocating storage for the array
	    private static void loadRandom(int[] arr) {
	        for (int k = 0; k < arr.length; k++) {
	            arr[k] = rand.nextInt();
	        } // end loop
	    } // end method
	    
	    // utility method for swapping two elements in an integer array
	    private static void swap(int[] arr, int k, int i) {
	        int temp = arr[i];
	        arr[i] = arr[k];
	        arr[k] = temp;
	    } // end swap
	    
	    // add any other methods you need/want

}
