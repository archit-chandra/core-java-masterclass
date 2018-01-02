package com.gemalto.variables;

public class FloatAndDouble {
	
	// 32 width (4 bytes)
	int myIntValue = 5;
	
	// 32 width (4 bytes)
	float myFloatValue = 5f;
	
	//far more precise in terms of float value (has more value after decimals)
	// 64 width (8 bytes)
	// more preferable in terms of performance also if it consumes more memory
	double myDoubleValue = 5d;  //5.25 also acceptable
	
}
