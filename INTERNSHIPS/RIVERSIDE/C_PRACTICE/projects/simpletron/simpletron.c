#include <stdio.h>

static int memory[100];
static int accumulator = 0;
static int instructionRegister = 0;
static int operationCode = 0;
static int instructionCounter;
static int operand = 0;

int main() {
    const int READ = 10;
    const int WRITE = 11;
    const int LOAD = 20;
    const int STORE = 21;
    const int ADD = 30;
    const int SUBTRACT = 31;
    const int DIVIDE = 32;
    const int MULTIPLY = 33;
    const int BRANCH = 40;
    const int BRANCHNEG = 41;
    const int BRANCHZERO = 42;
    const int HALT = 43;

    printf("*** Welcome to Simpletron!                       ***\n");
	printf("*** Please enter your program one instruction    ***\n");
	printf("*** (or data word) at a time. I will display     ***\n");
	printf("*** the location number and a question mark (?). ***\n");
	printf("*** You then type the word for that location.    ***\n");
	printf("*** Type 'quit' to stop entering the program.    ***\n");

    int inputting = 1;
    int instruction = 0;

    while (inputting = 1){
        int input;
        printf("%02d ? ",instruction);
        scanf("%d",&input);
        if(input <= 9999 && input >= -9999){ // TODO: needs rewritten does not work for all cases (letters)
            memory[instruction] = input;
        }
        else{
            continue;
        }
        instruction++;
    }
}