// strings are just arrays of characters with \0 at the end to end the string, each char is an address in memory

#include <stdio.h>
#include <string.h>

int main() {
    char * first_name = "John"; // pointer to a string (read only)
    char lastname[] = "Doe";
    return 0;
}