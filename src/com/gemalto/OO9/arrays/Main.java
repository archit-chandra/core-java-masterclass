package com.gemalto.OO9.arrays;

public class Main {
    
    // Arrays contain multiple value of same type = (primitive type + strings)
    // Array is a data structure to hold sequence of same data types
    public static void main(String[] args) {
        
        // Array handling
        
        // 1.
        int[] myIntArray = new int[10]; // double, long, etc
        myIntArray[5] = 50;
        myIntArray[6] = 60;
        myIntArray[7] = 70;
        myIntArray[8] = 80;
        
        System.out.println("8th element is " + myIntArray[7]);
        
        // 2.
        int[] myIntArray2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        System.out.println("8th element is " + myIntArray2[7]);
        System.out.println("5th element is " + myIntArray2[4]);
        
        // 3.
        int[] myIntArray3 = new int[10];
        
        for (int i = 0; i < 10; i++) {
            myIntArray3[i] = i * 30;
        }
        
        /*
         * for (int i = 0; i < 10; i++) { System.out.println("Element " + i +
         * ", value is " + myIntArray3[i]); }
         */
    }
}
