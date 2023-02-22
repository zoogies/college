
//Course:  CPS 151
//Semester: 2023 Spring
//Name: Ryan Zmuda
//Section: 01/03
//Assignment: 01
//Purpose: Demonstrating time complexity and efficiency of bubble and merge sort with optimizations
//Date completed: 2/21/23

import java.util.Random;

public class again {

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
    
    private static void loadRandom(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            arr[k] = rand.nextInt();
        } // end loop
    } // end method
    
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
        
        // TODO: Sort these arrays using bubble sort, show original and sorted
        // arrays and the  comparison counts (see sample output)
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

        
        // OPTIMIZED AFTER
        
        
        printarr("Original",brr);
        
        comparisons = 0;
        
        n = brr.length;
        int LP2C = n - 2;
        
        boolean swapMade = true;
        
        while (LP2C >= 0 && swapMade) {
            int LPS = -1;
            swapMade = false;
            for (int k = 0; k <= LP2C; k++) {
                comparisons++;
                if (brr[k] > brr[k + 1]) {
                    swap(arr, k, k + 1);
                    LPS = k;
                    swapMade = true;
                }
            }
            LP2C = LPS - 1;
        }
        
        printarr("Sorted",brr);
        System.out.println(comparisons + " comparisons\n");
    } // end method
    
    private static int BubbleSort(int[] brr) {
    	int comparisons = 0;
        
        int n = brr.length;
        int LP2C = n - 2;
        
        boolean swapMade = true;
        
        while (LP2C >= 0 && swapMade) {
            int LPS = -1;
            swapMade = false;
            for (int k = 0; k <= LP2C; k++) {
                comparisons++;
                if (brr[k] > brr[k + 1]) {
                    swap(brr, k, k + 1);
                    LPS = k;
                    swapMade = true;
                }
            }
            LP2C = LPS - 1;
        }
        
        return comparisons;
    }

    private static void demoMergeSort() {
        int arr[] = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int brr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int crr[] = {8, 15, 10, 13, 12, 9, 11, 14, 16, 4, 5, 6, 7, 1, 3, 2};
        
        System.out.println("\nMerge Sort comparison counts");
        System.out.println("==================================================");
        
        
        printarr("Original",arr);
        int compCount = mergeSort(arr);
        printarr("Sorted",arr);
        System.out.println("Number of comparisons: " + compCount);
        System.out.println();
        
        printarr("Original",brr);
        compCount = mergeSort(brr);
        printarr("Sorted",brr);
        System.out.println("Number of comparisons: " + compCount);
        System.out.println();
        
        printarr("Original",crr);
        compCount = mergeSort(crr);
        printarr("Sorted",crr);
        System.out.println("Number of comparisons: " + compCount);
        System.out.println();
    } // end method

    private static void collectAndPrintData() {
    	
    	System.out.println("\nBubble and Merge sorts and comparison counts (random arrays)");
        System.out.println("==================================================");
        

        System.out.printf("%-12s%-15s%-15s\n", "Array Size", "Bubble Comps", "Merge Comps");
        System.out.println("-------------------------------------------------");

        for (int i = 1000; i <= 10000; i += 1000) {
            int arr[] = new int[i];
            loadRandom(arr);
            int mcomp = mergeSort(arr);
            loadRandom(arr);
            int bcomp = BubbleSort(arr);
            System.out.printf("%-12d%-15d%-15d\n", i, bcomp, mcomp);
        }

    } // end method

    public static int mergeSort(final int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(final int[] arr, final int low, final int high) {
        int compCount = 0;

        if (high - low <= 0) {
            return compCount;
        }

        int mid = (low + high) / 2;

        compCount += mergeSort(arr, low, mid);
        compCount += mergeSort(arr, mid + 1, high);
        compCount += merge(arr, low, mid, high);

        return compCount;
    }

    private static int merge(final int[] arr, final int low, final int mid, final int high) {
        int compCount = 0;
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
            compCount++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];
        }

        return compCount;
    }

    // utility method for swapping two elements in an integer array
    private static void swap(int[] arr, int k, int i) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    } // end swap
    
}
