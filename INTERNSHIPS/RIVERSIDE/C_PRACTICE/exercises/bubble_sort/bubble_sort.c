// bubble sort, adapted from: https://geeksforgeeks.org/bubble-sort
#include <stdio.h>

// declare list to be sorted
int arr[] = {10,19,4,76,42,987,54,1,0,88,234,134};

// swap method to switch two values
void swap(int *xp, int *yp){
    int temp = *xp; // set temp int to the value at address pointed to by xp
    *xp = *yp; // set the value of the address xp points to to the value of the address yp points to
    *yp = temp; // set the value of the address yp points to to the value of temp
}

// sort method
void bubbleSort(int arr[], int n){
    // outer loop through every element
    for(int i = 0; i < n; i++){
        // inner loop through every element thats not in place (cutting off end of array thats already sorted)
        for(int j = 0; j < n - i - 1; j++){
            // check if value and its following value need to be switched
            if(arr[j] > arr[j + 1]){
                swap(&arr[j],&arr[j+1]); // switch the values
            }
        }
    }
}

// method to print array visually
void printArray(int arr[], int size){
    printf("["); // print the opening bracket
    for(int i = 0; i < size - 1; i++){
        printf("%d,",arr[i]); // print the nth element of the array with a comma
    }
    printf("%d]\n",arr[size - 1]); // print the last element of the array without a comma and the end bracket
}


// main method
int main() {
    int n = sizeof(arr) / sizeof(arr[0]); // calculate the number of elements in the array
    printf("Array Start:\n");
    printArray(arr,n); // output array
    bubbleSort(arr,n); // sort array
    printf("Sorted Array:\n");
    printArray(arr,n); // output sorted array
    return 0;
}