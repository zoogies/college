// adapted from https://tutorialspoint.com/cprogramming/switch_statement_in_c.htm

#include <stdio.h>

int main() {
    int num = 3;
    switch(num){
        case 1:
            printf("ONE\n");
        case 2:
            printf("TWO\n");
        default:
            printf("SOMETHING ELSE\n");
    }
    return 0;
}