package com.gemalto.OO9.arrays;

import java.util.Scanner;

public class ArrayAvgExample {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        
        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println("Enter " + i + ", typed value was :" + myIntegers[i]);
        }
        
        System.out.println("The average is  " + getAverage(myIntegers));
    }
    
    private static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("The sum is " + sum);
        return (double) sum / array.length;
    }
    
    private static int[] getIntegers(int number) {
        System.out.println("Enter " + number + "integer values.");
        int[] values = new int[number];
        
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }
    
}
