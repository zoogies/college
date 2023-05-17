#include <stdio.h>

int main() {
    typedef struct {
        char * name;
        int age;
    } person;

    person john;
    john.age = 27;
    john.name = "john";
    printf("%s is %d years old.", john.name, john.age);
    return 0;
}