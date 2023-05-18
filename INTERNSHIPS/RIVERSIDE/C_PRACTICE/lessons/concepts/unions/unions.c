// https://learn-c.org/en/Unions

// unions share same memory location, so only the space required for the largest of the union items is laid out

#include <stdio.h>

union hiddenMessage {
    int ints[6];
    char chars[21];
};

int main() {
    union hiddenMessage intCharacters = {{1853169737,1936876900,1684955508,1768838432,561213039,0}};

    for(int i = 0; i<19;i++)
        printf("%c",intCharacters.chars[i]);
    printf("%c\n",intCharacters.chars[19]);
    return 0;
}