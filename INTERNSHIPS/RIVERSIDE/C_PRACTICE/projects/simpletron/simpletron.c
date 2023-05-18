#include <stdio.h>
#include <ctype.h>

static int memory[100];
static int accumulator = 0;
static int instructionRegister = 0;
static int operationCode = 0;
static int instructionCounter;
static int operand = 0;

// memory dump
void dump(){
    printf("\nREGISTERS:\n");

    if(accumulator >= 0){
        printf("accumulator:\t\t+%04d\n",accumulator);
    }
    else{
        printf("accumulator:\t\t%05d\n",accumulator);
    }

    printf("instructionCounter:\t%02d\n",instructionCounter);

    if(instructionRegister >= 0){
        printf("instructionRegister:\t+%04d\n",instructionRegister);
    }
    else{
        printf("instructionRegister:\t%05d\n",instructionRegister);
    }

    printf("operationCode:\t\t%02d\n",operationCode);

    printf("operand:\t\t%02d\n\n",operand);


    printf("MEMORY:\n");
    printf("\t00\t01\t02\t03\t04\t05\t06\t07\t08\t09\t\n");
    for(int i = 0; i < 10; i++){
        printf("%02d\t",i*10);
        for(int j = 0; j < 10; j++){
            int current = memory[i * 10 + j];
            if(current >= 0){
                printf("+%04d\t",current);
            }
            else{
                printf("%05d\t",current);
            }
        }
        printf("\n");
    }
}

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

    // input loop

    while (inputting == 1){
        int input;
        printf("%02d ? ",instruction);
        if(scanf("%d",&input) != 1){
            
            // clear input buffer
            int c;
            while ((c = getchar()) != '\n' && c != EOF) {}
            
            if (isalpha(c)) {
                // printf("Invalid input. Please enter a numeric value.\n");
                inputting = 0;
            } else {
                // printf("Invalid input. Please enter a valid value.\n");
                inputting = 0;
            }

            continue;
        }
        if(input <= 9999 && input >= -9999){
            memory[instruction] = input;
        }
        else{
            printf("Value out of range (-9999,9999).\n");
            continue;
        }
        instruction++;
    }

    // running the program
    printf("\n*** Program loading completed. ***\n");
    dump();
    printf("\n*** Program execution begins. ***\n");
    
    for(instructionCounter = 0; instructionCounter < 99; instructionCounter++){
        instructionRegister = memory[instructionCounter];

        operationCode = instructionRegister / 100;
        operand = instructionRegister % 100;

        if(operationCode == READ){
            int valid = 0;
            int input = 0;
            while(valid != 1){
                printf("\nEnter data for location %d: ",operand);
                if(scanf("%d",&input) != 1){
                
                    // clear input buffer
                    int c;
                    while ((c = getchar()) != '\n' && c != EOF) {}
                    
                    if (isalpha(c)) {
                        printf("Invalid input. Please enter a numeric value.\n");
                        
                    } else {
                        printf("Invalid input. Please enter a valid value.\n");
                        
                    }

                    continue;
                }
                if(input > 9999 || input < -9999){
                    printf("Value out of range (-9999,9999).\n");
                    continue;
                }
                else{
                    valid = 1;
                }
            }
            memory[operand] = input;
        }
        else if(operationCode == WRITE){
            printf("\nData at location %d\n: ",operand);
            if(memory[operand] >= 0){
                printf("+%04d",memory[operand]);
            }
            else{
                printf("%04d",memory[operand]);
            }
        }
        else if(operationCode == LOAD){
            accumulator = memory[operand];
        }
        else if(operationCode == STORE){
            memory[operand] = accumulator;
        }
        else if(operationCode == ADD){
            if(accumulator + memory[operand] > 9999 || accumulator + memory[operand] < -9999){
                printf("\nERROR: ACCUMULATOR OVERFLOW\n");
                break;
            }
            else{
                accumulator += memory[operand];
            }
        }
        else if(operationCode == SUBTRACT){
            if(accumulator - memory[operand] > 9999 || accumulator - memory[operand] < -9999){
                printf("\nERROR: ACCUMULATOR OVERFLOW\n");
                break;
            }
            else{
                accumulator -= memory[operand];
            }
        }
        else if(operationCode == MULTIPLY){
            if(accumulator * memory[operand] > 9999 || accumulator * memory[operand] < -9999){
                printf("\nERROR: ACCUMULATOR OVERFLOW\n");
                break;
            }
            else{
                accumulator *= memory[operand];
            }
        }
        else if(operationCode == DIVIDE){
            if(memory[operand] == 0){
                printf("ERROR: CANT DIVIDE BY ZERO");
                break;
            }
            else{
                accumulator /= memory[operand];
            }
        }
        else if(operationCode == BRANCH){
            instructionCounter = operand;
        }
        else if(operationCode == BRANCHNEG){
            if(accumulator < 0){
                instructionCounter = operand;
            }
        }
        else if(operationCode == BRANCHZERO){
            if(accumulator == 0){
                instructionCounter = operand;
            }
        }
        else if(operationCode == HALT){
            break;
        }
        else{
            printf("\n***ERROR: Unknown operation code***\n");
            break;
        }
    }

    dump(); // final memory dump

}