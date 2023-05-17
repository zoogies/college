#include <stdio.h>
#include <stdlib.h>

int main() {
    int i,j;

    int **ptriangle = (int **) malloc(3 * sizeof(int *));
    ptriangle[0] = (int *) malloc(1 * sizeof(int *));
    ptriangle[1] = (int *) malloc(2 * sizeof(int *));
    ptriangle[2] = (int *) malloc(3 * sizeof(int *));

    ptriangle[0][0] = 1;

    ptriangle[1][0] = 1;
    ptriangle[1][1] = 1;

    ptriangle[2][0] = 1;
    ptriangle[2][1] = 2;
    ptriangle[2][2] = 1;

    for(i=0; i<3; i++){
        for(j=0; j<=i;j++){
            printf("%d",ptriangle[i][j]);
        }
        printf("\n");
    }

    for(i = 0; i < 3; i++){
        free(ptriangle[i]);
    }

    free(ptriangle);
    return 0;
}