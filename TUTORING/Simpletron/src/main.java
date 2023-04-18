import java.util.Scanner;

public class main {
	
	static int memory[] = new int[100];
	static int accumulator = 0;
	static int instructionRegister = 0;
	static int operationCode = 0;
	static int instructionCounter;
	static int operand = 0;
	
	public static void main(String[] args) {
		
		final int READ = 10;
		final int WRITE = 11;
		final int LOAD = 20;
		final int STORE = 21;
		final int ADD = 30;
		final int SUBTRACT = 31;
		final int DIVIDE = 32;
		final int MULTIPLY = 33;
		final int BRANCH = 40;
		final int BRANCHNEG = 41;
		final int BRANCHZERO = 42;
		final int HALT = 43;
		
		System.out.println("*** Welcome to Simpletron!                       ***\n"
				+ "*** Please enter your program one instruction    ***\n"
				+ "*** (or data word) at a time. I will display     ***\n"
				+ "*** the location number and a question mark (?). ***\n"
				+ "*** You then type the word for that location.    ***\n"
				+ "*** Type 'quit' to stop entering the program.    ***\n");
		
		boolean inputting = true;
		int instruction = 0;
		Scanner sc = new Scanner(System.in);
		
		while(inputting) {
			if(instruction <= 9) {
				System.out.print("0"+instruction + " ? ");
			}
			else {
				System.out.print(instruction + " ? ");
			}
			
			String input = sc.next();
			try {
				int current = Integer.parseInt(input);
				if(current <= 9999 && current >= -9999) {
					memory[instruction] = current;
				}
				else {
					System.out.println("\n***ERROR: Invalid word entered***\n");
					continue;
				}
			}
			catch(NumberFormatException e){
				inputting = false;
			}
			instruction++;
		}
		System.out.println("\n*** Program loading completed. ***\n");
		dump();
		System.out.println("\n*** Program execution begins. ***\n");
		
		// top level loop through all memory addresses
		for(instructionCounter = 0; instructionCounter < memory.length -1; instructionCounter++) {
			// copy current memory location to instructionRegister
			instructionRegister = memory[instructionCounter];
			
			// split instructionRegister into operationCode and operand
			operationCode = instructionRegister / 100;
			operand = instructionRegister % 100;
			
			if(operationCode == READ) {
				boolean valid = false;
				int num = 0;
				while(!valid) {
					System.out.print("Enter data for location " + operand+": ");
					String in = sc.next();
					try {
						num = Integer.parseInt(in);
						if(num <= 9999 && num >= -9999) {
							valid = true;
							break;
						}
					}catch(NumberFormatException e){
						//pass
					}
					System.out.println("ERROR: Must be between -9999 and 9999");
					
				}
				
				memory[operand] = num;
			}
			else if(operationCode == WRITE) {
				System.out.print("Data at location "+ operand+": ");
				String mem;
				if(memory[operand] >= 0) {
					mem = "+"+format(4, memory[operand]);
				}
				else {
					mem = "-"+format(4, Math.abs(memory[operand]));
				}
				System.out.println(mem);
			}
			else if(operationCode == LOAD) {
				accumulator = memory[operand];
			}
			else if(operationCode == STORE) {
				memory[operand] = accumulator;
			}
			else if(operationCode == ADD) {
				if(accumulator + memory[operand] > 9999 || accumulator + memory[operand] < -9999) {
					System.out.println("ERROR: ACCUMULATOR OUT OF BOUNDS");
					break;
				}
				else {
					accumulator += memory[operand]; // only do if accumulator wont go outside of -9999 to 9999
				}
			}
			else if(operationCode == SUBTRACT) {
				if(accumulator - memory[operand] > 9999 || accumulator - memory[operand] < -9999) {
					System.out.println("ERROR: ACCUMULATOR OUT OF BOUNDS");
					break;
				}
				else {
					accumulator -= memory[operand]; // only do if accumulator wont go outside of -9999 to 9999
				}
			}
			else if(operationCode == MULTIPLY) {
				if(accumulator * memory[operand] > 9999 || accumulator * memory[operand] < -9999) {
					System.out.println("ERROR: ACCUMULATOR OUT OF BOUNDS");
					break;
				}
				else {
					accumulator *= memory[operand]; // only do if accumulator wont go outside of -9999 to 9999
				}
			}
			else if(operationCode == DIVIDE) {
				if(memory[operand] == 0) {
					System.out.println("ERROR: CANT DIVIDE BY ZERO");
					break;
				}
				else {
					accumulator /= memory[operand]; // do not allow dividing by zero
				}
				
			}
			else if(operationCode == BRANCH) {
				instructionCounter = operand;
			}
			else if(operationCode == BRANCHNEG) {
				if(accumulator < 0) {
					instructionCounter = operand;
				}
			}
			else if(operationCode == BRANCHZERO) {
				if(accumulator == 0) {
					instructionCounter = operand;
				}
			}
			else if(operationCode == HALT) {
				break;
			}
			else {
				System.out.println("\n***ERROR: Unknown operation code***\n");
				break;
			}
		}
		dump();
	}
	
	public static String format(int digits, int num) {
		return String.format("%0" + digits + "d", num);
	}
	
	public static void dump() {
		System.out.println("\nREGISTERS:");
		
		String accu;
		if(accumulator >= 0) {
			accu = "+"+format(4, accumulator);
		}
		else {
			accu = "-"+format(4, Math.abs(accumulator));
		}
		
		System.out.println("accumulator: \t\t" + accu);
		
		System.out.println("instructionCounter: \t"+ format(2,instructionCounter));
		
		String ic;
		if(instructionRegister >= 0) {
			ic = "+"+format(4, instructionRegister);
		}
		else {
			ic = "-"+format(4, Math.abs(instructionRegister));
		}
		System.out.println("instructionRegister: \t"+ic);
		
		System.out.println("operationCode: \t\t"+ format(2,operationCode));
		System.out.println("operand: \t\t"+ format(2,operand));
		
		System.out.println("\nMEMORY:");
		System.out.println("\t00\t01\t02\t03\t04\t05\t06\t07\t08\t09\t");
		
		for (int i = 0; i < 10; i++) {
			
			if(i == 0) {
				System.out.print("00\t");
			}
			else {
				System.out.print(format(2, i * 10)+"\t");
			}
			
            for (int j = 0; j < 10; j++) {
            	
            	int current = memory[i * 10 + j];
            	
            	if(current >= 0) {
            		System.out.print("+"+format(4, current) + "\t");
            	}
            	else {
            		System.out.print("-"+format(4, Math.abs(current)) + "\t");
            	}
            	
            }
            
            System.out.println();
        }
		
	}

}
