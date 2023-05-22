// bogo sort (for fun and to test speed)
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>

// check if array is sorted and return true if so, and false if not
bool checkSorted(int data[], int n){
    for(int i = 0; i < n - 1; i++){
        if(data[i] > data[i+1]){
            return false;
        }
    }
    return true;
}

// swap two values by pointer parameters
void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

// shuffle an array of n size using the fisher-yates shuffle
void shuffle(int data[], int n){
    srand(time(NULL));
    for(int i = n - 1; i > 0; i--){
        int j = rand() % (i + 1);
        swap(&data[i],&data[j]);
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
    int data[] = {3,2,1,0};
    int size = sizeof(data) / sizeof(data[0]);

    int counter = 0;

    printf("Unsorted Array:\n");
    printArray(data,size);

    while(!checkSorted(data,size)){
        shuffle(data,size);
        counter++;
    }

    printf("Sorted Array:\n");
    printArray(data,size);

    setlocale(LC_NUMERIC,"");

    printf("Required %'d shuffles\n",counter);

    return 0;
}