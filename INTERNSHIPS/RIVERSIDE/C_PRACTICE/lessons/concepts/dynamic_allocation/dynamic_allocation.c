#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x;
    int y;
} point;

int main() {
    point * mypoint = NULL;
    mypoint = (point *) malloc(sizeof(point));
    mypoint->x=1;
    mypoint->y=1;

    printf("mypoint coordinates: %d, %d\n",mypoint->x,mypoint->y);
    free(mypoint);
    return 0;
}