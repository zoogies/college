#include <stdio.h>

void print_big(int n){
    if(n>10){
        printf("%d is big!\n",n);
    }
}

int main() {
    print_big(11);
    return 0;
}