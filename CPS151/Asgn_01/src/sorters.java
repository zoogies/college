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

	    void merge(int arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	  
	        /* Create temp arrays */
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	  
	        /*Copy data to temp arrays*/
	        for (int i = 0; i < n1; ++i)
	            L[i] = arr[l + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = arr[m + 1 + j];
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	  
	        // Initial index of merged subarray array
	        int k = l;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                arr[k] = L[i];
	                i++;
	            }
	            else {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	  
	    // Main function that sorts arr[l..r] using
	    // merge()
	    void sort(int arr[], int l, int r)
	    {
	        if (l < r) {
	            // Find the middle point
	            int m = l + (r - l) / 2;
	  
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr, m + 1, r);
	  
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }

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
