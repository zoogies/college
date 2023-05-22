#include <stdio.h>

int main() {
    int c;
    FILE *file;
    file = fopen("data.txt", "r");
    if(file){
        while((c=getc(file)) != EOF){
            putchar(c);
        }
        fclose(file);
    }
    return 0;
}