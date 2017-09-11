package com.ex736;

public class Simpletron {

	// accumulator - place where information is put before the simpletron uses that ifno
	// 100 words memory
	// load appliction before eveyrthing else
		// first insturcton is always placed in location 00
	// each instruction occupies one word of the simpletron's memmory - instructions are assigned 4 digit codes
	// first two digits are the operation code 
	// last two digits are the operands - the address of the memory location where the word to which the operatio applies
	
	// input / output operations:
	private final int READ = 10;		// read a wordk from the keyboard into a specific location in memory
	private final int WRITE = 11;		// write a word from a secific location in memory to the screen
	
	// load / store operations:
	private final int LOAD = 20;		// load a word from a specific location in memory into the accumulator
	private final int STORE = 21;		// store a word from the accumulator into a specific location in memory
	
	// arithmetic operations:
	private final int ADD = 30;			// add a word from a secific location in memmoery to the word in the accumulator (leave the result in the accumulator)
	private final int SUBTRACT = 31;	// Subtract a word from a specific location in memory from the word in the accumulator (leave the resutl in the accumulator)
	private final int DIVIDE = 32;		// Divide a word from a specific location in memory from the word in the accumulator (leave the resutl in the accumulator)
	private final int MULTIPLY = 33;	// Multiply a word from a specific location in memory from the word in the accumulator (leave the resutl in the accumulator)
	
	// transfer of control:
	private final int BRANCH = 40;		// Branch to a specific location in memory
	private final int BRANCHNEG = 41;	// Branch to a specific location in memory if accumulator is negative
	private final int BRANCHZERO = 42;	// Branch to a specific location in memory if accumulator is zero
	private final int HALT = 43;		// Halt. The program has completed its task
}