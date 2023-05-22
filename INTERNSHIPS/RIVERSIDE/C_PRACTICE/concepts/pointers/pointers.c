#include <stdio.h>

// pointers hold a memory address that points to a value instead of the actual value itself

int main() {
    int n = 1;
    int * pointer_to_n = &n;

    printf("n is %d, and is also %d\n",n,*pointer_to_n);
    return 0;
}