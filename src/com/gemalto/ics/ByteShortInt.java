package com.gemalto.ics;

public class ByteShortInt {
	
	// -2.7Billion(-2147483648) to 2.7Billion(2147483647) => 2^31
	//  2_147_483_648 - allowed since Java7
	// 32 width
	int myIntValue = 1000;
	
	// (-128) to (127)
	// 8 width
	byte myByteValue = 100;
	
	// -32768 to 32767
	// 16 width
	short myShortValue = 6000;
	
	// 2^63
	// 64 width
	long myLongValue = 100L;

}
