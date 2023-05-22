#include <stdio.h>

int main() {
    int array[] = {1,7,4,5,9,3,5,11,6,3,4};
    int i = 0;

    while(i<10){
        if(i < 5){
            i++;
            continue;
        }
        else if(i > 10){
            i++;
            break;
        }

        printf("%d\n",array[i]);
        i++;
    }

    return 0;
}