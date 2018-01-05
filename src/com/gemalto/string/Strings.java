package com.gemalto.string;

// byte
// short
// int
// long
// float
// double
// char
// boolean



// like a ninth primitive data type
public class Strings {
	public static void main(String[] args) {
		
		String myString = "This is a string";
		System.out.println("myString = " + myString);
		
		// + works as a String appender
		myString = myString +  " and this is appended string";
		System.out.println("myString = " + myString);
		
		// adding unicode character also
		myString = myString + " \u00A9 2015";
		System.out.println("myString = " + myString);
		
		// adding string & number (it appends!!)
		// operator overloading of '+'
		String numberString = "250.55";
		numberString = numberString + "49.55";
		System.out.println("numberString = " + numberString); //250.5549.55
		
		String lastString = "10";
		int myInt = 50;
		lastString = lastString + myInt;
		System.out.println("lastString = " + lastString); //1050
		
		// same with double and other data types

	}

}
