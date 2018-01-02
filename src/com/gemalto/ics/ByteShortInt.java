package com.gemalto.ics;

public class ByteShortInt {
	
	// -2.7Billion(-2147483648) to 2.7Billion(2147483647) => 2^31
	//  2_147_483_648 - allowed since Java7
	// 32 width
	int myIntValue = 1000;
	int myNewIntValue = (myIntValue/2);
	
	// (-128) to (127)
	// 8 width
	byte myByteValue = 100;
	byte myNewByteValue = (byte) (myByteValue/2);
	
	// -32768 to 32767
	// 16 width
	short myShortValue = 6000;
	short myNewShortValue = (short) (myShortValue/2);
	
	// 2^63
	// 64 width
	long myLongValue = 100L;
	long myNewLongValue = (long) (myLongValue/2);
	
	// hence int is preferred, because Java converts to int by default after each operation 

}
